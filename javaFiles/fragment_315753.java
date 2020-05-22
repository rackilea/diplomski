public static void main(String[] args)
{
    Path path = Paths.get("some path"); // TODO Change to path to an CSV file

    try (Stream<String> lines = Files.lines(path))
    {
        List<List<String>> rows = lines
                // Map each line of the file to its fields (String[])
                .map(line -> line.split(","))
                // Map the fields of each line to unmodifiable lists
                .map(fields -> Collections.unmodifiableList(Arrays.asList(fields))
                // Collect the unmodifiable lists in an unmodiable list (listception)
                .collect(Collectors.toUnmodifiableList());

        // Ensure file is not empty.
        if (rows.isEmpty())
        {
            throw new IllegalStateException("empty file");
        }

        // Ensure all lines have the same number of fields.
        int fieldsPerRow = rows.get(0).size();
        if (!rows.stream().allMatch(row -> row.size() == fieldsPerRow))
        {
            throw new IllegalStateException("not all rows have the same number of fields");
        }

        // Assume the file has a header line appearing as the first line.
        System.out.printf("Column names: %s\n", rows.get(0));

        // Read the data rows.
        rows.stream()
                .skip(1) // Skip header line
                .forEach(System.out::println);
    }
    catch (IOException | UncheckedIOException e)
    {
        e.printStackTrace(); // TODO Handle exception
    }
}