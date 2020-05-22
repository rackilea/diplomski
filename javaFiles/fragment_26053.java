try (BufferedReader in = Files.newBufferedReader​(Paths.get(filename))) {
    in.mark(1024);
    String line = in.readLine();
    if (line == null)
        throw new IOException("File is empty: " + filename);
    CSVFormat fileFormat = (line.indexOf('\t') != -1 ? CSVFormat.TDF
                                                     : CSVFormat.RFC4180)
            .withHeader();
    in.reset();

    for (CSVRecord record : fileFormat.parse(in)) {
        String lastName = record.get("Last Name");
        String firstName = record.get("First Name");
        ...
    }
}