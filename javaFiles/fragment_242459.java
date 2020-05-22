try (BufferedWriter writer = Files.newBufferedWriter(Paths.get(outputFile));
        CSVPrinter csvPrinter = new CSVPrinter(writer, CSVFormat.DEFAULT.withHeader(Header.class));) {
    for (Map<Header, String> row : output) {
        csvPrinter.printRecord(Arrays.asList(Header.values())
                                     .stream()
                                     .map(header -> row.get(header))
                                     .collect(Collectors.toList()));
    }
} catch (IOException ex) {
    Logger.getLogger(TestCSV.class.getName())
          .log(Level.SEVERE, null, ex);
}