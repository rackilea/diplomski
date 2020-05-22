FileObject jfo = filer.getResource(StandardLocation.SOURCE_OUTPUT, "", "test.txt");
String msg = TUtils.JFOToString(jfo);    // Reads FileObject as String
jfo.delete();

jfo = filer.createResource(StandardLocation.SOURCE_OUTPUT, "", "test.txt");
TUtils.writeJFO(jfo, msg + "Hallo ich bin Processor 2");    // Writes String to FileObject
filer.close();