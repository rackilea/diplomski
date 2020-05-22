public static void main(String[] args) {
    try (BufferedInputStream in = new BufferedInputStream(
            new FileInputStream("D:\\input.txt"))) {
        dumpBytes(in, 2551 - 10, 20);
    } catch (IOException ex) {
        ex.printStackTrace();
    }
}

private static void dumpBytes(InputStream in, long offset, int length)
        throws IOException {
    long pos = in.skip(offset);
    while (length >= 0) {
        int b = in.read();
        if (b == -1) {
            break;
        }
        b &= 0xFF;
        System.out.printf("%6d: 0x%02x %s '%c'%n", pos, b,
            toBinaryString(b), (32 <= b && b < 127 ? (char)b : '?'));

        --length;
        ++pos;
    }
}

private static String toBinaryString(int b) {
    String s = Integer.toBinaryString(b);
    s = "00000000" + s;
    s = s.substring(s.length() - 8);
    s = s.substring(0, 4) + "_" + s.substring(4);
    return s;
}