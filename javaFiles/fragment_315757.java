if ((response.getRows() != null) && !response.getRows().isEmpty()) {
  // Display headers.
  for (AdsenseReportsGenerateResponseHeaders header : response.getHeaders()) {
    System.out.printf("%25s", header.getName());
  }
  System.out.println();

  // Display results.
  for (List<String> row : response.getRows()) {
    for (String column : row) {
      System.out.printf("%25s", column);
    }
    System.out.println();
    }

  System.out.println();
} else {
  System.out.println("No rows returned.");
}