public static String compress(String s) {
    Deflater def = new Deflater(9);
    byte[] sbytes = s.getBytes(StandardCharsets.UTF_8);
    def.setInput(sbytes);
    def.finish();
    byte[] buffer = new byte[sbytes.length];
    int n = def.deflate(buffer);
    return new String(buffer, 0, n, StandardCharsets.ISO_8859_1)
            + "*" + sbytes.length;
}

public static String decompress(String s) {
    int pos = s.lastIndexOf('*');
    int len = Integer.parseInt(s.substring(pos + 1));
    s = s.substring(0, pos);

    Inflater inf = new Inflater();
    byte[] buffer = s.getBytes(StandardCharsets.ISO_8859_1);
    byte[] decomp = new byte[len];
    inf.setInput(buffer);
    try {
        inf.inflate(decomp, 0, len);
        inf.end();
    } catch (DataFormatException e) {
        throw new IllegalArgumentException(e);
    }
    return new String(decomp, StandardCharsets.UTF_8);
}