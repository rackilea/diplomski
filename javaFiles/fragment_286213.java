InputStream openStream(File file) {
    try {
        return new FileInputStream(gred_file);
    } catch (IOException e) {
        return null;
    }
}