public static String toAlphabeticRadix(int num) {
    char[] str = Integer.toString(num, 26).toCharArray();
    for (int i = 0; i < str.length; i++) {
        str[i] += str[i] > '9' ? 10 : 49;
    }
    return new String(str);
}