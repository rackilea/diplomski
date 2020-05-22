public static boolean repeatedString(String str, String repeat, int lastIndex) {
    int next = str.indexOf(repeat, lastIndex+repeat.length());

    if(next == -1) return false;
    else if(next-lastIndex == repeat.length()) return true;
    else return repeatedString(str, repeat, next);
}