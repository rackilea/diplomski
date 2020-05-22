public void readFile(final String file)
    throws IOException
{
    final Path path = Paths.get(file);
    for (final String line: Files.readAllLines(path, StandardCharsets.UTF_8))
        System.out.println(line);
}