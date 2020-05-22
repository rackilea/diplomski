Document document = new Document();
PdfCopy copy = new PdfSmartCopy(document, new FileOutputStream(dest));
document.open();
PdfReader reader;
String line = br.readLine();
// loop over readers
    // add the PDF to PdfCopy
    reader = new PdfReader(baos.toByteArray());
    copy.addDocument(reader);
    reader.close();
// end loop
document.close();