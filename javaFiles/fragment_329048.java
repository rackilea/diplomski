public static void convert1252toUFT8(String fileName) throws IOException {
    Path in = Paths.get(fileName), out = Paths.get(fileName+"x");
    int readCount = 0, writeCount = 0;
    CharsetDecoder dec = Charset.forName("windows-1252")
            .newDecoder().onUnmappableCharacter(CodingErrorAction.IGNORE);
    try(Reader br = Channels.newReader(Files.newByteChannel(in), dec, -1);
…