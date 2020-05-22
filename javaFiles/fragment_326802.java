pdfStamper.setFormFlattening(true);
pdfStamper.close();
pdfReader.close();
//Create a new pdfReader which reads the existing baos
pdfReader = new PdfReader(baos.toByteArray());
Document document = new com.itextpdf.text.Document();
PdfCopy copy = null;
ByteArrayOutputStream copyBaos = new ByteArrayOutputStream();
//Create Copy of the same.
copy = new PdfCopy(document, copyBaos);
document.open();
// Keep only selected pages
copy.addDocument(pdfReader, pagesToKeep);