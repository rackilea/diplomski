//Original file DataHandler
DataHandler bigDocDH = new DataHandler(new FileDataSource(bigFile));

Document document = new Document();
String replaceToken = UUID.randomUUID().toString();
//DataHandler with content replaced by the XMLStreamWriterWrapper
DataHandler tokenDH = new DataHandler(new ByteArrayDataSource(replaceToken.getBytes(Charset.forName("UTF-8")), bigDocDH.getContentType()));
document.setText(tokenDH);

try (OutputStream outStream = new FileOutputStream(outFile)) {
    XMLStreamWriter streamWriter = XMLStreamWriterWrapper.newInstance(outStream, bigDocDH, replaceToken);
    marshaller.marshal(document, streamWriter);
}