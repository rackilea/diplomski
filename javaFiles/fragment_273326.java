//Save JasperPrint to jrpxml (xml format)
JRXmlExporter exporter = new JRXmlExporter();
exporter.setExporterInput(new SimpleExporterInput(jasperPrint));
exporter.setExporterOutput(new SimpleWriterExporterOutput(new File("myJasperPrint.jrpxml")));
exporter.exportReport();

//Load jrpxml to JasperPrint object
JasperPrint print = JRPrintXmlLoader.load("myJasperPrint.jrpxml");

//To show it in JasperViewer
JRViewer jrv = new JRViewer(print);