// support loading the JKS from the classpath (to get around Tomcat limitation)
private static File getTuringKeyStoreFile() throws IOException {
    ClassPathResource resource = new ClassPathResource("test.jks");

    // Tomcat won't allow reading File from classpath so read as InputStream into temp File
    File jks = File.createTempFile("ssl_keystore", ".jks");
    InputStream inputStream = resource.getInputStream();
    try {
        FileUtils.copyInputStreamToFile(inputStream, jks);
    } finally {
        IOUtils.closeQuietly(inputStream);
    }

    return jks;
}