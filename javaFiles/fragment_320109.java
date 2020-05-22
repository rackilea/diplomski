public static void copyMatchingLines(final Path src, final Path dst,
    final String... searchStrings)
    throws IOException
{
    final Predicate<String> predicate
        = s -> Arrays.stream(searchStrings).anyMatch(s::contains);

    try (
        final Stream<String> lines = Files.lines(src, StandardCharsets.UTF_8);
        final BufferedWriter writer = Files.newBufferedWriter(dst, StandardCharsets.UTF_8,
            StandardOpenOption.CREATE_NEW);
    ) {
        lines.filter(predicate).forEach(line -> {
            writer.write(line);
            writer.newLine();
        });
        writer.flush();
    }
}