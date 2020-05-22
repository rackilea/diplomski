try (final CSVReader reader = 
    new CSVReader(new InputStreamReader(new FileInputStream(myFile), Charset.forName("UTF-8")), '\t')) {
    String[] line;
    while ((line = reader.readNext()) != null) {

    }
}