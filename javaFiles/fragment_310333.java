package so20190412;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Snippet {

    public Snippet() {
    }

    public static void main(String[] args) {        

        Map<String, String> attributes = new HashMap<String, String> () {{
            put("john", "doe");
            put("bruce", "wayne");
        }};
        List<String> lines = Arrays.asList("My name is {{john}}, not {{bruce}}.", "Hello, {{john}}!", "How are you doing?");

        new Snippet().replaceAll(attributes, lines).forEach(System.out::println);

    }

    public List<String> replaceAll(Map<String, String> attributes, List<String> lines) {
        return lines.stream().map(l -> parse(attributes, l)).collect(Collectors.toList());
    }

    public String parse(Map<String, String> attributes, String line) {
        String[] pLine = {line};
        attributes.entrySet().stream()
                .forEach(attr -> {
                    String attributeKey = attr.getKey();
                    String attributeValue = attr.getValue();
                    String newLine = pLine[0].replace("{{" + attributeKey + "}}", attributeValue);
                    pLine[0] = newLine;
                });
        return pLine[0];
    }
}