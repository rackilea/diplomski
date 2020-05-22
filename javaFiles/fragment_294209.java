private static char[] trimLeadingSpaces(char[] arr) {
    String str = new String(arr);
    while (str.length() > 0 && str.charAt(0) == ' ')
        str = str.substring(1);
    return str.toCharArray();
}

private static int idxFirstSpace(char[] arr, int currentIdx) {
    return new String(arr).indexOf(' ', currentIdx);
}