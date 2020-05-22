String html = "";
try {
    InputSupplier<? extends InputStream> supplier = Resources
            .newInputStreamSupplier(metaUrl);
    html = CharStreams.toString(CharStreams.newReaderSupplier(supplier,
            Charsets.UTF_8));
} catch (Exception e) {
    return null;
}