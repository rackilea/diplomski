List jpList = new ArrayList();
jpList.add(JRLoader.loadObjectFromFile("build/reports/Report1.jrprint")); 
...
JRExporter exporter = new JRPdfExporter(); 
exporter.setParameter(JRPdfExporterParameter.JASPER_PRINT_LIST, jpList); 
exporter.setParameter(JRPdfExporterParameter.OUTPUT_STREAM, stream); 
exporter.exportReport();