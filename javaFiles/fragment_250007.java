PdfPTable table = new PdfPTable(1);
PdfPCell cell = new PdfPCell();
cell.setRunDirection(PdfWriter.RUN_DIRECTION_RTL);
for (Element e : elements) {
    cell.addElement(e);
}
table.addCell(cell);
document.add(table);