static String padWithZeroes(String yourInputString, int digits) {
    final Matcher matcher = SINGLE_DIGIT.matcher(yourInputString);
    StringBuffer sb = new StringBuffer();
    while(matcher.find()){

        matcher.appendReplacement(sb, pad(digits - matcher.group().length())+matcher.group());
    }
    matcher.appendTail(sb);
    return sb.toString();
}

static String pad(int length) {
    final char[] chars = new char[length];
    Arrays.fill(chars, '0');
    return new String(chars);
}