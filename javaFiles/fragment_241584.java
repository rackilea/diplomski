package demo;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {

    private static final char OPENED_BRACKET = '{';
    private static final char CLOSED_BRACKET = '}';
    private static final String OPENED_BRACKET_REPLACOR = "##OPENED_BRACKET_REPLACOR##";
    private static final String CLOSED_BRACKET_REPLACOR = "##CLOSED_BRACKET_REPLACOR##";

    private static final String REGEX    = "\\{((.|\\n|\r|\t)*?)\\}";
    private static final Pattern PATTERN = Pattern.compile(REGEX);

    public String preprocessing(String origin) {
        StringBuilder replaced = new StringBuilder();
        int opened = 0;
        for(int index = 0 ; index < origin.length() ; index++) {
            char current_char = origin.charAt(index);
            String processed  = Character.toString(current_char);

            if(current_char == OPENED_BRACKET) {
                if(opened++ > 0) {
                    processed = OPENED_BRACKET_REPLACOR; 
                }
            }

            else if(current_char == CLOSED_BRACKET) {
                if(--opened > 0) {
                    processed = CLOSED_BRACKET_REPLACOR; 
                }
            }

            replaced.append(processed);
        }
        return replaced.toString();
    }

    public List<String> extract(String source) {
        final Matcher matcher = PATTERN.matcher(source);
        List<String> list = new ArrayList<>();
        while(matcher.find()) {
            list.add(matcher.group(1));
        }
        return list;
    }

    public List<String> postprocessing(List<String> source) {
        List<String> result = new ArrayList<>();
        for(String src: source) {
            result.add(src.replaceAll(OPENED_BRACKET_REPLACOR, Character.toString(OPENED_BRACKET))
                          .replaceAll(CLOSED_BRACKET_REPLACOR, Character.toString(CLOSED_BRACKET)));
        }
        return result;
    }

    public static void main(String[] args) {
        Parser parser = new Parser();
        String code = "if (a == 6) { method1(); if (a < 2) { method3(); } }if (a == 5) { method1();\n\r" +
                      " method2() }";
        String preprocessed = parser.preprocessing(code);
        List<String> extracted = parser.extract(preprocessed);
        List<String> postprocessed = parser.postprocessing(extracted);
        for(String ifContent: postprocessed) {
            System.out.println("Line: " + ifContent);
        }
    }
}