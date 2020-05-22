public void createPdf(String dest) throws IOException, DocumentException {
    Document document = new Document();
    PdfWriter.getInstance(document, new FileOutputStream(dest));
    document.open();
    PdfPTable table = new PdfPTable(2);
    table.setSplitLate(false);
    table.setWidths(new int[]{1, 15});
    for (int i = 1; i <= 20; i++) {
        table.addCell(String.valueOf(i));
        table.addCell("It is not smart to use iText 2.1.7!");
    }
    PdfPTable innertable = new PdfPTable(2);
    innertable.setWidths(new int[]{1, 15});
    for (int i = 0; i < 90; i++) {
        innertable.addCell(String.valueOf(i + 1));
        innertable.addCell("Upgrade if you're a professional developer!");
    }
    table.addCell("21");
    table.addCell(innertable);
    for (int i = 22; i <= 40; i++) {
        table.addCell(String.valueOf(i));
        table.addCell("It is not smart to use iText 2.1.7!");
    }
    document.add(table);
    document.close();
}