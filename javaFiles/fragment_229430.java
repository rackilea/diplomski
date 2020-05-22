JasperPrint jasperPrint = JasperFillManager.fillReport("myReport.jasper", reportParameters, dataSource);

Exporter exporter = new JRDocxExporter();
exporter.setExporterInput(new SimpleExporterInput(jasperPrint));

File exportReportFile = new File("D:\\Temp\\report.docx");

exporter.setExporterOutput(new SimpleOutputStreamExporterOutput(exportReportFile));

exporter.exportReport();