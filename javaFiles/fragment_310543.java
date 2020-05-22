public static void main(String[] args) throws IOException {
CsvBeanReader csvBeanReader = null;
try {

    // your csv file
    String csvFile = null;
    csvBeanReader = new CsvBeanReader(csvFile), CsvPreference.EXCEL_NORTH_EUROPE_PREFERENCE);

    final String[] headersArray = csvBeanReader.getHeader(true);
    List<String> headers = Arrays.asList(headersArray);
    List<String> expectedHeaders = Arrays.asList("street", "city");
    if (!expectedHeaders.equals(headers)) {
        return;
    }

    final CellProcessor[] processors = new CellProcessor[] { new NotNull(), new NotNull() };

    List<ProductDetail> productDetails = new ArrayList<>();
    ProductDetail productDetail = null;

    while ((productDetail = csvBeanReader.read(ProductDetail.class, headersArray, processors)) != null) {
      productDetails.add(productDetail);
    }
    // save products in your DB
}
finally {
    try {
      csvBeanReader.close();
    }
    catch (IOException e) {
      e.printStackTrace();
    }
}
}