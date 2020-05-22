public static char[] grade(int[] m) {
    char[] g = new char[m.length];
    for (int i = 0; i < m.length; i++) {
        if (m[i] >= 80)
            g[i] = 'H';
        else if (m[i] >= 70)
            g[i] = 'D';
        else
            g[i] = 'F';
    }
    return g;
}