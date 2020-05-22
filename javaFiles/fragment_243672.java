public void createPdf(String dest) throws IOException, DocumentException {
    Document document = new Document();
    PdfWriter.getInstance(document, new FileOutputStream(dest));
    document.open();
    // I see 3 columns in your example
    PdfPTable table = new PdfPTable(3);
    // The first column appears to have double the width of the other columns
    table.setWidths(new int[]{ 2, 1, 1});
    // the first row consists of 1 cell that spans the 3 columns
    PdfPCell c1 = new PdfPCell(new Phrase("Content 1"));
    c1.setColspan(3);
    table.addCell(c1);
    // Then follows a row with normal cells
    table.addCell("Content 2");
    table.addCell("Content 3");
    table.addCell("Content 4");
    // Again we have a row with 1 cell that spans 3 columns
    PdfPCell c5 = new PdfPCell(new Phrase("Content 5"));
    c5.setColspan(3);
    table.addCell(c5);
    // Now we have a row with 1 normal cell and 1 that spans 2 columns
    table.addCell("Content 7.1");
    PdfPCell c7 = new PdfPCell(new Phrase("Content 7.2"));
    c7.setRowspan(2);
    table.addCell(c7);
    // now we can add the table
    document.add(table);
    document.close();
}