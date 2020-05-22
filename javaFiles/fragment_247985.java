private B(InputStream is) {
    super(is);
    // Whatever else is needed
}

public static B newInstance(File file) {
    B result;
    try (FileInputStream stream = new FileInputStream(file)) {
        result = new B(stream);
    }
    // Further processing
    return result;
}