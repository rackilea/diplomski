//Initialize PDF writer
PdfWriter writer = new PdfWriter(dest);
//Initialize PDF document
PdfDocument pdf = new PdfDocument(writer);
// Initialize document
Document document = new Document(pdf);
//Add paragraph to the document
document.add(new Paragraph("Hello World!"));
//Close document
document.close();