private class TemporaryFileInputStream extends FileInputStream {
    public TemporaryFileInputStream(File file) throws FileNotFoundException {
        super(file);
    }

    @Override
    public void close() throws IOException {
        super.close();
        file.delete();
    }
}