// p is my report
JasperPrint p = ..........

StringBuffer xml = new StringBuffer();

JRXmlExporter xmlExporter = new JRXmlExporter();
xmlExporter.setParameter(JRExporterParameter.JASPER_PRINT, p);
xmlExporter.setParameter(JRExporterParameter.OUTPUT_STRING_BUFFER, xml);
xmlExporter.exportReport();

File file = File.createTempFile("temp", ".xml"); 
BufferedWriter bw = new BufferedWriter(new FileWriter(file));
bw.write(xml.toString());
bw.close();