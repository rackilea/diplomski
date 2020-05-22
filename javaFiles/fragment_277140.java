Document doc = new Document();
PdfWriter pdfWriter = PdfWriter.getInstance(doc, outfile);
pdfWriter.setPageEvent(new ShadowEvent());
doc.open();
Chunk c = new Chunk("60");
c.setGenericTag("shadow");
doc.add(c);
doc.close();