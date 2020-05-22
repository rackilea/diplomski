PdfDocument doc = new PdfDocument(
  new PdfWriter(pdfOutputStream, 
    new WriterProperties().setCompressionLevel(0)));
doc.addNewPage();
SvgConverter.drawOnDocument(svg, doc, 1);
doc.close();