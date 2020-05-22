PdfPTable table=new PdfPTable(1);

PdfPCell pdfWordCell = new PdfPCell();
Phrase firstLine = new Phrase("text goes here", boldFont );
Phrase secondLine = new Phrase("normal text goes here", normalFont );

pdfWordCell.addElement(firstLine );
pdfWordCell.addElement(secondLine );

table.addCell(  pdfWordCell );