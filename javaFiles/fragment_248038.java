public static boolean contentEquals(InputStream input1, InputStream input2)
        throws IOException {
    if (!(input1 instanceof BufferedInputStream)) {
        input1 = new BufferedInputStream(input1);
    }
    if (!(input2 instanceof BufferedInputStream)) {
        input2 = new BufferedInputStream(input2);
    }

    int ch = input1.read();
    while (EOF != ch) {
        int ch2 = input2.read();
        if (ch != ch2) {
            return false;
        }
        ch = input1.read();
    }

    int ch2 = input2.read();
    return ch2 == EOF;
}