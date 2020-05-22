private final static byte NL = 10;// new line
    private final static byte EOF = -1;// end of file
    private final static byte EOL = 0;// end of line

private static String readLine(BufferedInputStream reader,
            String accumulator) throws IOException {
        byte[] container = new byte[1];
        reader.read(container);
        byte byteRead = container[0];
        if (byteRead == NL || byteRead == EOL || byteRead == EOF) {
            return accumulator;
        }
        String input = "";
        input = new String(container, 0, 1);
        accumulator = accumulator + input;
        return readLine(reader, accumulator);
    }