PdfPTable table = new PdfPTable(2);
PdfPCell imageCell = new PdfPCell();
imageCell.addElement(Image.getInstance(IMG));
imageCell.setRowspan(2);
table.addCell(imageCell);
table.addCell(new Phrase("1"));
table.addCell(new Phrase("2"));