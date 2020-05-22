public static boolean isValidStringRec(String s) {
    if(s == null)
        return false;
    if(s.length() <= 1)
        return true;
    if(s.charAt(0) == s.charAt(s.length()-1))
        return isValidStringRec(s.substring(1, s.length()-1));
    return false;
}