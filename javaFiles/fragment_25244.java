public static String trimTrailingWhitespace(String toTrim) {
    if(toTrim == null){
        return "";
    }
    int end = toTrim.length();
    if (end > 0) {
        int current = end - 1;
        while (current > 0) {
            char currentChar = toTrim.charAt(current);
            if (Character.isWhitespace(currentChar) && !(currentChar == '\n' || currentChar == '\r')) {
                //if the character is whitespace and not a newline, increase current
                current--;
            } else {
                break;
            }
        }
        if(current == 0){
            return "";
        }else {
            return toTrim.substring(0, current + 1);
        }
    }else{
        return toTrim;
    }
}