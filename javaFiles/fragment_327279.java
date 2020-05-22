public static String replace5CharHex(String input){

    String REGEX = "([a-fA-F\\d]{5})";
    String tmpSubstring = "";

    Pattern p = Pattern.compile(REGEX);
    Matcher m = p.matcher(input);
    StringBuffer sb = new StringBuffer();
    while (m.find()) {

        tmpSubstring = hashManager.createNewHash(m.group());
        m.appendReplacement(sb, tmpSubstring);
    }
    m.appendTail(sb);

    return sb.toString();

}