public static String read(String file) throws IOException {
    StringBuilder builder = new StringBuilder();
    try (InputStream input = new FileInputStream(file)) {
        BufferedReader reader = new BufferedReader(
            new InputStreamReader(input, "UTF-8"));
        String line;
        while ((line = reader.readLine()) != null) {
            builder.append(line);
        }
    }
    return builder.toString();
}