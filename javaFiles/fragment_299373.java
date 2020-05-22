public static FileInputStream openUnchecked(File file) {
    try {
        return new FileInputStream(file);
    } catch (FileNotFoundException e) {
        // Just wrap the exception in an unchecked one.
        throw new RuntimeException(e);
    }
}