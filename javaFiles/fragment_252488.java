File dataDir = new File("/tmp/data");
URL url = new URL("http://www.site.com/book/1.html");
final File targetFile = new File(dataDir, url.getFile());
final File targetDir = targetFile.getParentFile();
if (!targetDir.exists() && !targetDir.mkdirs()) {
    throw new SomeException("Failed to create parent directory " + targetDir);
}
// continue using targetFile