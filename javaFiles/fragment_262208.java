PdfPTable table = new PdfPTable(1);
table.setWidthPercentage(50);
table.addCell("Different images, one after the other vertically:");
PdfPCell cell = new PdfPCell();
cell.addElement(img1);
cell.addElement(img2);
cell.addElement(img3);
table.addCell(cell);
document.add(table);