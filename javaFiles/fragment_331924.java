JRMapArrayDataSource dataSource = new JRMapArrayDataSource(data);

JasperReport jasperReport = JasperCompileManager.compileReport(reportJRXMLSource);
JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, params, dataSource);

JRXlsxExporter exporter = new JRXlsxExporter();
exporter.setParameter(JRXlsExporterParameter.JASPER_PRINT, jasperPrint);
exporter.setParameter(JRXlsExporterParameter.OUTPUT_FILE_NAME, outputFileName);

exporter.exportReport();