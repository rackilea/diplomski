public class Demo {
    private static final Pattern WORD = 
        Pattern.compile("\"((?:[^\\\\\"]|\\\\.)*)\"|([^\\s\"]+)");

    public static void main(String[] args) {
        String  cmd = 
           "command "                                  +
           "\"string with blanks\" "                   +
           "\"anotherStringBetweenQuotes\" "           +
           "\"a string with \\\"escaped\\\" quotes\" " + 
           "stringWithoutBlanks";

        Matcher matcher = WORD.matcher(cmd);
        while (matcher.find()) {
            String capturedGroup = matcher.group(1) != null ? matcher.group(1) : matcher.group(2);
            System.out.println("Matched: " + capturedGroup);
        }
    }
}