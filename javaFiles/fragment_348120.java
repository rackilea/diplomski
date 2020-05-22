PdfDocument pdfDoc = new PdfDocument(new PdfWriter("D://qwqw12.pdf"));
Document doc = new Document(pdfDoc, PageSize.A4);
doc.add(new Paragraph("Hi"));
doc.getPdfDocument().setDefaultPageSize(PageSize.A4.rotate());
doc.add(new AreaBreak());
doc.add(new Paragraph("Hi2"));
doc.add(new AreaBreak());
doc.add(new Paragraph("Hi3"));
doc.close();