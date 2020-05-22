StaxDriver drv = new StaxDriver();
XStream xstream = new XStream(drv);
StringWriter strWriter = new StringWriter();
StaxWriter sw = new StaxWriter(drv.getQnameMap(),
   drv.getOutputFactory().createXMLStreamWriter(strWriter),
   false, // don't do startDocument
   true); // do repair namespaces
xstream.marshal(ktpMessage, sw);
sw.close();
String objectXml = strWriter.toString();