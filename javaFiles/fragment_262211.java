p = new Paragraph("The quick brown ");
p.add(new Chunk(img3, 0, 0, true));
p.add(" jumps over the lazy ");
p.add(new Chunk(img2, 0, 0, true));
cell = new PdfPCell();
cell.addElement(p);
table.addCell(cell);