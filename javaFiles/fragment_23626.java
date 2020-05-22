public ByteArrayOutputStream fillXLS(JasperPrint jasperPrint) throws Exception{
     ByteArrayOutputStream baos = new ByteArrayOutputStream();
     JRXlsExporter exporterXls = new JRXlsExporter();
     exporterXls.setParameter( JRExporterParameter.JASPER_PRINT, jasperPrint );
     exporterXls.setParameter( JRExporterParameter.OUTPUT_STREAM, baos);
     exporterXls.exportReport(); 
     exporterXlsbaos;
}