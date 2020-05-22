PdfPTable table = new PdfPTable(5);
table.setWidthPercentage(100);
PdfPCell cell = new PdfPCell(new Phrase("Table XYZ (Continued)"));
cell.setColspan(5);
table.addCell(cell);
cell = new PdfPCell(new Phrase("Continue on next page"));
cell.setColspan(5);
table.addCell(cell);
table.setHeaderRows(2);
table.setFooterRows(1);
table.setSkipFirstHeader(true);
table.setSkipLastFooter(true);
for (int i = 0; i < 350; i++) {
    table.addCell(String.valueOf(i+1));
}
document.add(table);