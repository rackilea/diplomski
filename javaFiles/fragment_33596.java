static long repeatedString(String s, long n) {
    long len = s.length();

    if (len == 0)
        return 0;

    long rep = n / len;
    long count = 0;

    for (int i = 0; i < len; i++) {
        if (s.charAt(i) == 'a')
            count++;
    }

    count *= rep;

    long rest = n % len;

    for (int i = 0; i < rest; i++) {
        if (s.charAt(i) == 'a')
            count++;
    }
    return count;
}