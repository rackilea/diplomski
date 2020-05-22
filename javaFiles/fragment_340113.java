ICsvMapReader mapReader = new CsvMapReader(
      new FileReader("foo.csv"), CsvPreference.EXCEL_PREFERENCE);
 try {
  final String[] headers = mapReader.getHeader(true);
  Map<String, String> row;
  while( (row = mapReader.read(headers)) != null) {
    for (String header : headers) {
      System.out.println(header + " is " + row.get(header));
    }
  }
} finally {
  mapReader.close();
}