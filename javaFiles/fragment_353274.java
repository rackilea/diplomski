// Nothing here should throw IOException in reality - work out what you want to do.
public byte[] convertStream(Charset encoding) throws IOException {       
    ByteArrayInputStream original = new ByteArrayInputStream(raw.toByteArray());
    InputStreamReader contentReader = new InputStreamReader(original, encoding);

    int readCount;
    char[] buffer = new char[4096];
    try (ByteArrayOutputStream converted = new ByteArrayOutputStream()) {
        try (Writer writer = new OutputStreamWriter(converted, StandardCharsets.UTF_8)) {
            while ((readCount = contentReader.read(buffer, 0, buffer.length)) != -1) {
                writer.write(buffer, 0, readCount);
            }
        }
        return converted.toByteArray();
    }
}