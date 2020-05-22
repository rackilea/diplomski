public static void generujp() throws DocumentException {
    Document dokument = new Document();
    try {
        PdfWriter.getInstance(dokument, new FileOutputStream("example.pdf"));
        dokument.open();
        Paragraph paragraf = new Paragraph();
        paragraf.add("Arkusz inwentaryzacyjny");
        dokument.add(paragraf);
        dokument.close();
    } catch (FileNotFoundException e) {
        e.printStackTrace();
    } catch (DocumentException e) {
        e.printStackTrace();
        throw e;
    }
}