public static String trimString(String string, int length, boolean soft) {
    if(string == null || string.trim().isEmpty()){
        return string;
    }

    StringBuffer sb = new StringBuffer(string);
    int actualLength = length - 3;
    if(sb.length() > actualLength){
        // -3 because we add 3 dots at the end. Returned string length has to be length including the dots.
        if(!soft)
            return escapeHtml(sb.insert(actualLength, "...").substring(0, actualLength+3));
        else {
            int endIndex = sb.indexOf(" ",actualLength);
            return escapeHtml(sb.insert(endIndex,"...").substring(0, endIndex+3));
        }
    }
    return string;
}