public ByteArrayOutputStream fillPDF(JasperPrint jasperPrint) throws Exception{
     ByteArrayOutputStream baos = new ByteArrayOutputStream();
     JRPdfExporter exporter = new JRPdfExporter();
     exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
     exporter.setParameter(JRPdfExporterParameter.OUTPUT_STREAM,baos); 
     exporter.exportReport(); 
     return baos;
}