public static void main(String[] args) {
    String input = "ltm data-group internal str_testclass { \n" +
            "    records { \n" +
            "        baz { \n" +
            "            data \"value 1\" \n" +
            "        } \n" +
            "        foobar { \n" +
            "            data \"value 2\" \n" +
            "        }\n" +
            "        topaz {}\n" +
            "    } \n" +
            "    type string \n" +
            "}";

    String bazValue = getRecord("baz", input);
    String foobarValue = getRecord("foobar", input);
    String topazValue = getRecord("topaz", input);

    System.out.println("Record data value for 'baz' is '" + bazValue + "'");
    System.out.println("Record data value for 'foobar' is '" + foobarValue + "'");
    System.out.println("Record data value for 'topaz' is '" + topazValue + "'");
}

private static String getRecord(String key, String input) {
    String regex = key + "\\s\\{\\s*\\n\\s*data\\s*\"([^\"]*)\"";
    final Pattern pattern = Pattern.compile(regex);
    Matcher matcher = pattern.matcher(input);
    if (matcher.find()) {
        //if we find a record with data return it
        return matcher.group(1);
    } else {
        //else see if the key exists with empty {}
        final Pattern keyPattern = Pattern.compile(key);
        Matcher keyMatcher = keyPattern.matcher(input);
        if (keyMatcher.find()) {
            //return empty string if key exists with empty {}
            return "";
        } else {
            //else handle error, throw exception, etc.
            System.err.println("Record not found for key: " + key);
            throw new RuntimeException("Record not found for key: " + key);
        }
    }
}