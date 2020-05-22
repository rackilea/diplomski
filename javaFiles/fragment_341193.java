public class RegexMain {
    static final String PATTERN = "\\(([^)]+)\\)|\"[^\"]*\"";
    static final Pattern CONTENT = Pattern.compile(PATTERN);
    /**
     * @param args
     */
    public static void main(String[] args) {
        String testString = "Rhyme (Jack) and (Jill) went up the hill on \"(Peter's)\" request.";
        Matcher match = CONTENT.matcher(testString);
        while(match.find()) {
            if(match.group(1) != null) {
                System.out.println(match.group(1)); // prints Jack, Jill
            }
        }
    }
}