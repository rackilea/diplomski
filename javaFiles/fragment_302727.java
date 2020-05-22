public InputStream createPdf() throws IOException {
    ByteArrayOutputStream out = new ByteArrayOutputStream();            
    try (Document doc = new Document(PageSize.A4, 50, 50, 50, 50)) {
        PdfWriter writer = PdfWriter.getInstance(doc, out);
        doc.open();
        PdfPTable table = new PdfPTable(1);
        PdfPCell cell = new PdfPCell(new Phrase("First PDF"));
        cell.setBorder(Rectangle.NO_BORDER);
        cell.setRunDirection(PdfWriter.RUN_DIRECTION_LTR);
        table.addCell(cell);
        doc.add(table);
    }
    return new ByteArrayInputStream(out.toByteArray());
}