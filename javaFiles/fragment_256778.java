PdfPTable table = new PdfPTable(5);
table.setWidthPercentage(100);
PdfPCell cell = new PdfPCell(new Phrase("Table XYZ (Continued)"));
cell.setColspan(5);
table.addCell(cell);
table.setHeaderRows(1);
table.setSkipFirstHeader(true);
for (int i = 0; i < 350; i++) {
    table.addCell(String.valueOf(i+1));
}
document.add(table);