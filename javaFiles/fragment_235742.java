public static String replace(String source,char oldChar,char newChar){
    char[] temp = source.toCharArray();
    StringBuilder result = new StringBuilder();
    for (char c : temp) {
        if(c == oldChar){
            result.append(newChar);
        }else result.append(c);
    }
    return result.toString();
}