final Path transferFile = Files.createTempFile("transfer", "xxx");

// transfer file to transferFile

// Sure it's not 1252?
final Charset srcCharset = Charset.forName("windows-1251");

final Path dstFile = Paths.get("destinationFile");
final Charset dstCharset = StandardCharsets.UTF_8;

final char[] buf = new char[16384]; // or another size
int charsRead;

try (
    final BufferedReader reader = Files.newBufferedReader(transferFile, srcCharset);
    final BufferedWriter writer = Files.newBufferedWriter(dstFile, dstCharset);
) {
    while ((charsRead = reader.read(buf)) != -1)
        writer.write(buf, 0, charsRead);
    writer.flush();
}

Files.delete(transferFile);