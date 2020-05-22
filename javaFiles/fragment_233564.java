String source = "folder/source.zip";
String destination = "folder/source/";
String password = "password";

try {
    ZipFile zipFile = new ZipFile(source);
    if (zipFile.isEncrypted()) {
        zipFile.setPassword(password);
    }
    zipFile.extractAll(destination);
} catch (ZipException e) {
    e.printStackTrace();
}