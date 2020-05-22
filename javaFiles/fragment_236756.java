final Charset srcCharset = Charset.forName("windows-1251");

final Path dstFile = Paths.get("destinationFile");
final Charset dstCharset = StandardCharsets.UTF_8;

try (
    final FileSystem sshfs = xxx;
    final BufferedReader reader 
        = Files.newBufferedReader(sshfs.getPath("sourcepath"), srcCharset);
    final BufferedWriter writer  = Files.newBufferedWriter(dstFile, dstCharset);
) {
    while ((charsRead = reader.read(buf)) != -1)
        writer.write(buf, 0, charsRead);
    writer.flush();
}