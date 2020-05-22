private List<String> getResourceFiles(String path) throws IOException {
    List<String> filenames = new ArrayList<>();

    try (
            InputStream in = getResourceAsStream(path);
            BufferedReader br = new BufferedReader(new InputStreamReader(in))) {
        String resource;

        while ((resource = br.readLine()) != null) {
            filenames.add(resource);
        }
    }

    return filenames;
}

private InputStream getResourceAsStream(String resource) {
    final InputStream in
            = getContextClassLoader().getResourceAsStream(resource);

    return in == null ? getClass().getResourceAsStream(resource) : in;
}

private ClassLoader getContextClassLoader() {
    return Thread.currentThread().getContextClassLoader();
}