List<String[]> resolvedData;
    String[][] array;

    public void parseURLs() throws FileNotFoundException {

        CsvParserSettings settings = new CsvParserSettings();
        settings.getFormat().setLineSeparator("\n");
        CsvParser parser = new CsvParser(settings);

        try {
            resolvedData = parser.parseAll(new FileReader("C:\\Users\\kevin.anderson\\Desktop\\book1.csv"));
            array = new String[resolvedData.size()][];
            resolvedData.toArray(array);
        } catch (Exception ex) {
            System.out.println(ex.toString());
        }
    }