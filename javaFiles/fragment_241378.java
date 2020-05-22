public static char[] replaceSpaces(char[] str_array) {
    StringBuilder sb = new StringBuilder();
    for (char ch : str_array) {
        sb.append((ch != ' ') ? ch : "%20");
    }
    return sb.toString().toCharArray();
}