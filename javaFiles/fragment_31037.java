public class ImportMatching {
    static final String IMPORTS = "import\n" +
        "java.io.IOException;\n" +
        "import java.nio.file.Files;\n" +
        "import   java  .   nio .  file.   Path;\n" +
        "import  java.nio.file.Paths\n" +
        ";import java.util.ArrayList;\n" +
        "import  static   java.util. List.*;\n" +
        "import java.util.List. *;\n" +
        "import java.\n" +
        "       util.\n" +
        "       List;\n" +
        " import java.util.regex.Matcher;import java.util.regex.Pattern\n" +
        "         ;\n" +
        "import mypackage.mystuff;\n" +
        "import mypackage.*;";
    static final String WS = "\\p{javaWhitespace}";
    static final String IG = "\\p{javaIdentifierIgnorable}";
    static final String ID = "\\p{javaJavaIdentifierStart}" + multiple(charClass("\\p{javaJavaIdentifierPart}" + IG));
    static final String DOT = multiple(WS) + "\\." + multiple(WS);
    static final String WC = "\\*";
    static final String REGEX = "import" + multiple(IG) + atLeastOnce(WS) +
        optional(nonCapturingGroup("static" + multiple(IG) + atLeastOnce(WS))) +
        group(
            ID +
            nonCapturingGroup(
                or(
                    DOT + WC,
                    atLeastOnce(nonCapturingGroup(DOT + ID)) + optional(nonCapturingGroup(DOT + WC))
                )
            )
        ) +
        multiple(WS) + ';';

    public static void main(String[] args) {
        final List<String> imports = getImports(IMPORTS);
        System.out.printf("Matches: %d%n", imports.size());
        imports.stream().forEach(System.out::println);
    }

    static List<String> getImports(String javaSource) {
        Pattern pattern = Pattern.compile(REGEX);
        Matcher matcher = pattern.matcher(javaSource);
        List<String> imports = new ArrayList<>();
        while(matcher.find()) {
            imports.add(matcher.group(1).replaceAll(charClass(WS + IG), ""));
        }
        return imports;
    }

    static String nonCapturingGroup(String regex) {
        return group("?:" + regex);
    }

    static String or(String option1, String option2) {
        return option1 + '|' + option2;
    }

    static String atLeastOnce(String regex) {
        return regex + '+';
    }

    static String optional(String regex) {
        return regex + '?';
    }

    static String multiple(String regex) {
        return regex + '*';
    }

    static String group(String regex) {
        return '(' + regex + ')';
    }

    static String charClass(String regex) {
        return '[' + regex + ']';
    }
}