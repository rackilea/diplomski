public static int getIndexOfFirstInt(String line) {
    char[] chars = line.toCharArray();
    for (char c : chars) {
        if (Character.isDigit(c)) {
            return line.indexOf(c);
        }
    }
    return -1;
}