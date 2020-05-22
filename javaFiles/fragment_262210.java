Paragraph p = new Paragraph();
img1.scalePercent(30);
p.add(new Chunk(img1, 0, 0, true));
p.add(new Chunk(img2, 0, 0, true));
p.add(new Chunk(img3, 0, 0, true));
cell = new PdfPCell();
cell.addElement(p);
table.addCell(cell);