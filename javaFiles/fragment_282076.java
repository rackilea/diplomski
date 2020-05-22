public String everyNth(String str, int n) {
    if (n < 1) {
        throw new IllegalArgumentException("n must be greater than 0");
    }
    StringBuilder result = new StringBuilder(str);
    // This will replace every nth character with '-'
    for (int i = n - 1; i < str.length(); i += n) {
        result.setCharAt(i, '-');
    }
    return result.toString();
}