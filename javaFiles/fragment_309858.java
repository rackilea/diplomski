String text = "...."
String remoteFileName = "..."
FTPClient ftp = ... // Already connected

try (ByteArrayInputStream local = new ByteArrayInputStream(text.toBytes("UTF-8"))) {
    ftp.appendFile(remoteFilename, local);
} catch (IOException ex) {
    throw new RuntimeException("Uh-oh", ex);
}