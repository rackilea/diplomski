package test;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test {
    public static void main(String[] args) throws Exception {
        String input = Files.readString(Paths.get("src/main/java/test/Test.java"));

        String keyword = "\\b(?:else|if|int|return|void|while|for|package|import|public|protected|private|static|class|throws)\\b";
        String identifier = "\\b[a-zA-Z][a-zA-Z0-9]*\\b";
        String number = "-?\\b[\\d]+\\b";
        String regex = "(" + keyword + ")|(" + identifier + ")|(" + number + ")";
        Pattern pattern = Pattern.compile(regex);
        for (Matcher m = pattern.matcher(input); m.find(); ) {
            if (m.start(1) != -1)
                System.out.println("Keyword: " + m.group());
            else if (m.start(2) != -1)
                System.out.println("Identifier: " + m.group());
            else
                System.out.println("Number: " + m.group());
        }
    }
}