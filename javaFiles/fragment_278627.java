public static StringBuilder removePunctuation(StringBuilder s) {
    for (int i=s.length() - 1; i >= 0; i--) {
        if(s.charAt(i)=='!' || s.charAt(i)=='\'' || s.charAt(i)=='.'| s.charAt(i)==','|| s.charAt(i)=='?') {
        s.deleteCharAt(i); 
    }
}