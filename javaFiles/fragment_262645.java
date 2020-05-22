public static int findBase(String str) {
    int max = 0;
    str = str.toUpperCase();
    for (int i = 0; i < str.length(); i++) {
        char c = str.charAt(i);
        int v = 0;
        if (c >= '0' && c <= '9') {
            v = c - '0';
        } else if (c >= 'A' && c <= 'Z') {
            v = 10 + (c - 'A');
        }
        if (v > max) {
            max = v;
        }
    }
    return max + 1;
}