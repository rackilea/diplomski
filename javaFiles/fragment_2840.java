public boolean copyFile(File source, File destination) throws CopyException {
    try {
        // lots of code
        return true;
    } catch (IOException e) {
        throw new CopyException("File copy failed", e);
    }
}