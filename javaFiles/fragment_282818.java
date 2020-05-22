private int customStringComparator(String s1, String s2) {
    int len1 = s1.length();
    int len2 = s2.length();
    int lim = Math.min(len1, len2);
    char v1[] = s1.toCharArray();
    char v2[] = s2.toCharArray();

    int k = 0;
    while (k < lim) {
        char c1 = v1[k];
        char c2 = v2[k];
        // You can add your custom comparison here:
        if ('_' == c1 && Character.isDigit(c2)) {
            // We intentionally return inverted result
            return c2  - c1;
        }else if(c1 != c2) {
            return c1 - c2;
        }
        k++;
    }
    return len1 - len2;
}