byte[] input = getBytesFromFile(new File("C:/data/HelloWorld.pdf"));
ByteArrayOutputStream output = new ByteArrayOutputStream();
com.aspose.pdf.Document pdfDocument = new com.aspose.pdf.Document(new ByteArrayInputStream(input));
pdfDocument.save(output);
//If you want to read the result into a Document object again, in Java you need to get the
//data bytes and wrap into an input stream.
InputStream inputStream=new ByteArrayInputStream(output.toByteArray());