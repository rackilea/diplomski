private int myAtoi(String input){
    Pattern p = Pattern.compile("(\\-|\\+)\\d+");
    Matcher m = p.matcher(input);

    if (!m.find())
        return 0;
    else
        return Integer.valueOf(m.group());
}