Optional<InputStream> openStream(File file) {
    try {
        return Optional.of(new FileInputStream(gred_file));
    } catch (IOException e) {
        return Optional.empty();
    }
}