//Get our main report
JasperReport report = JasperCompileManager.compileReport("jsonMain.jrxml");

//Open url connection
URLConnection urlConn = new URL("http://www.jdd.it/so/jsonTest.json").openConnection();
//set some cookies
urlConn.setRequestProperty("Cookie", "cookie1=hello; cookie2=world");

//Get the stream
try (InputStream is =urlConn.getInputStream()) {
    Map<String, Object> parametersMap = new HashMap<>();
    //Pass to parameter map
    parametersMap.put(JsonQueryExecuterFactory.JSON_INPUT_STREAM, is);
    //Fill report
    JasperPrint jasperPrint = JasperFillManager.fillReport(report, parametersMap);
    //Export to pdf
    JRPdfExporter exporter = new JRPdfExporter();
    exporter.setExporterInput(new SimpleExporterInput(jasperPrint));
    exporter.setExporterOutput(new SimpleOutputStreamExporterOutput("json.pdf"));
    SimplePdfExporterConfiguration configuration = new SimplePdfExporterConfiguration();
    configuration.setMetadataAuthor("Me");
    exporter.setConfiguration(configuration);
    exporter.exportReport();
}