JRXlsExporter exporterXls = new JRXlsExporter();
exporterXls.setExporterInput(new SimpleExporterInput(jasperPrint));
exporterXls.setExporterOutput(new SimpleOutputStreamExporterOutput(new File("excelTest.xls")));
SimpleXlsReportConfiguration configXls = new SimpleXlsReportConfiguration();
configXls.setShowGridLines(false);
//set your additional settings
exporterXls.setConfiguration(configXls);
exporterXls.exportReport();