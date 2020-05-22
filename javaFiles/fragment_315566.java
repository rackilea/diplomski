private File exportReportPDF(JasperPrint jp, File file) throws JRException,  FileNotFoundException {
    JRExporter exporter = new JRPdfExporter();
    exporter.setParameter(JRExporterParameter.JASPER_PRINT, jp);
    exporter.setParameter(JRExporterParameter.OUTPUT_FILE, file);
    exporter.exportReport();
    return file;
}