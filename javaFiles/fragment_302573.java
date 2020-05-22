PdfPTable table = new PdfPTable(2);
table.addCell("A");
PdfPCell cell = new PdfPCell(new Phrase("C"));
cell.setRowspan(2);
table.addCell(cell);
table.addCell("B");