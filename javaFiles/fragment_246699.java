public void loadLibrary(String library) throws IOException {
    InputStream source = getClass().getResourceAsStream(library);
    File tempFile = File.createTempFile("javatmp", ".dll");
    FileOutputStream dest = new FileOutputStream(tempFile);
    try {
        IOUtils.copy(source, dest)
    }
    finally {
        dest.close();
        source.close();
    }
    System.load(tempFile.getAbsolutePath());
    tempFile.delete();
}