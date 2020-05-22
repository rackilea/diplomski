// "in" is the InputStream from the remote file
final Charset srcCharset = Charset.forName("windows-1251");

final Path dstFile = Paths.get("destinationFile");
final Charset dstCharset = StandardCharsets.UTF_8;

try (
    final FileSystem sshfs = xxx;
    final Reader reader = new InputStreamReader(in, srcCharset);
    final BufferedWriter writer  = Files.newBufferedWriter(dstFile, dstCharset);
) {
    while ((charsRead = reader.read(buf)) != -1)
        writer.write(buf, 0, charsRead);
    writer.flush();
}