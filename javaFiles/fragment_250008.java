PdfPTable table = new PdfPTable(1);
PdfPCell cell = new PdfPCell();
cell.setRunDirection(PdfWriter.RUN_DIRECTION_RTL);
for (Element e : elements) {
    if (e == Chunk.NEXTPAGE)
    {
        table.addCell(cell);
        document.add(table);
        document.newPage();
        table = new PdfPTable(1);
        cell = new PdfPCell();
    }
    else
    {
        cell.addElement(e);
    }
}
table.addCell(cell);
document.add(table);