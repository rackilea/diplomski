try (final InputStream is = A.class.getResourceAsStream("data.txt");
        final Reader r = new InputStreamReader(is, StandardCharsets.UTF_8);
        final BufferedReader br = new BufferedReader(r);
        final Stream<String> lines = br.lines()) {

}