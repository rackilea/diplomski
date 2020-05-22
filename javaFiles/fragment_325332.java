try (InputStream in = new BufferedInputStream(
    Files.newInputStream(Paths.get(csvDirectory, filename)))) {

    ByteBuffer lineBuffer = ByteBuffer.allocate(64 * 1024);

    int b = 0;
    while (b >= 0) {
        lineBuffer.clear();

        for (b = in.read();
             b >= 0 && b != '\n' && b != '\r';
             b = in.read()) {

            lineBuffer.put((byte) b);
        }

        if (b == '\r') {
            in.mark(1);
            if (in.read() != '\n') {
                in.reset();
            }
        }

        lineBuffer.flip();
        byte[] bytes = new byte[lineBuffer.limit()];
        lineBuffer.get(bytes);

        // First decoding: £ is represented as four characters
        String parsedLine = new String(bytes, "UTF-8");

        bytes = new byte[parsedLine.length()];
        for (int i = parsedLine.length() - 1; i >= 0; i--) {
            bytes[i] = (byte) parsedLine.charAt(i);
        }
        // Second decoding: £ is represented as two characters
        parsedLine = new String(bytes, "UTF-8");

        bytes = new byte[parsedLine.length()];
        for (int i = parsedLine.length() - 1; i >= 0; i--) {
            bytes[i] = (byte) parsedLine.charAt(i);
        }
        // Third decoding: £ is represented as one character
        parsedLine = new String(bytes, "UTF-8");

        // ...
    }
}