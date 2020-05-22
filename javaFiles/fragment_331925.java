JasperReport jasperReport;
try (InputStream inputStream = JRLoader.getResourceInputStream(jrxmlFilePath)) {
    jasperReport = JasperCompileManager.compileReport(JRXmlLoader.load(inputStream));
}
Map<String, Object> params = new HashMap<>();

JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, params, new JREmptyDataSource());

SimpleXlsxReportConfiguration configuration = new SimpleXlsxReportConfiguration();
configuration.setOnePagePerSheet(true);
configuration.setIgnoreGraphics(false);

File outputFile = new File("output.xlsx");
try (ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
     OutputStream fileOutputStream = new FileOutputStream(outputFile)) {
    Exporter exporter = new JRXlsxExporter();
    exporter.setExporterInput(new SimpleExporterInput(jasperPrint));
    exporter.setExporterOutput(new SimpleOutputStreamExporterOutput(byteArrayOutputStream));
    exporter.setConfiguration(configuration);
    exporter.exportReport();
    byteArrayOutputStream.writeTo(fileOutputStream);
}