public void readFile(final String file)
    throws IOException
{
    final Path path = Paths.get(file);
    try (
        final BufferedReader reader = Files.newBufferedReader(path,
            StandardCharsets.UTF_8);
    ) {
        String line;
        while ((line = reader.readLine()) != null)
            System.out.println(line);
    }
}