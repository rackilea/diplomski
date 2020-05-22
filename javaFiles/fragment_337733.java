PdfWriter writer = new PdfWriter(OUTPUT_FILE);
PdfDocument pdfDocument = new PdfDocument(writer);
Document document = new Document(pdfDocument);
document.add(new Paragraph("Hello world"));
PdfImageXObject thumbnail = new PdfImageXObject(ImageDataFactory.create(getInput("itext.png")));
pdfDocument.getFirstPage().getPdfObject().put(PdfName.Thumb, thumbnail.getPdfObject());
document.close();