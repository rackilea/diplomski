// inner table 1
PdfPTable innertable = new PdfPTable(5);
innertable.setWidths(new int[]{8, 12, 1, 4, 12});
// first row
// column 1
cell = new PdfPCell(new Phrase("Record Ref:"));
cell.setBorder(Rectangle.NO_BORDER);
innertable.addCell(cell);
// column 2
cell = new PdfPCell(new Phrase("GN Staff"));
cell.setPaddingLeft(2);
innertable.addCell(cell);
// column 3
cell = new PdfPCell();
cell.setBorder(Rectangle.NO_BORDER);
innertable.addCell(cell);
// column 4
cell = new PdfPCell(new Phrase("Date: "));
cell.setBorder(Rectangle.NO_BORDER);
innertable.addCell(cell);
// column 5
cell = new PdfPCell(new Phrase("30/4/2015"));
cell.setPaddingLeft(2);
innertable.addCell(cell);
// spacing
cell = new PdfPCell();
cell.setColspan(5);
cell.setFixedHeight(3);
cell.setBorder(Rectangle.NO_BORDER);
innertable.addCell(cell);