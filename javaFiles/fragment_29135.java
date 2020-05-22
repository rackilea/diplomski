private static void printChristmasTree(int n) {
    final int w = n * 2 - 1;
    char[] buf = new char[w * 3 - 2];
    Arrays.fill(buf, ' ');
    for (int i = w - 1; i < buf.length; i += 2)
        buf[i] = '#';
    for (int s = 0; s < w; s += 2)
        System.out.println(new String(buf, s, s + w));
}