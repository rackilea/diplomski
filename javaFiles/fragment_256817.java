protected String FixHexValuesInString(String str) {

    Matcher matcher = Pattern.compile("\\\\x([0-9a-f]{2})").matcher(str);    
    StringBuffer sb = new StringBuffer();
    while (matcher.find()) {
        int codepoint = Integer.valueOf(matcher.group(1), 16);
        matcher.appendReplacement(sb, String.valueOf((char) codepoint));
    }
    return matcher.appendTail(sb).toString();
}