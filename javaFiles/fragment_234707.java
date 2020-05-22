final Path csvpath = Paths.get(statSource);

try (
    final InputStream in = Files.newInputStream(csvpath);
    final CsvReader csv = new CsvReader(in, ';', Charset.forName("windows-1250");
) {
    // operate on csv
}