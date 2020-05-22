public static PdfWriter getWriter(Document document) throws FileNotFoundException, DocumentException {
    PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(filename));
    HeaderFooter event = new HeaderFooter("Ing. Mario J. Schwaiger", type + " " + DDMMYYYY.format(new java.util.Date()), 835, isLetterPDF(), customerNumber);
    writer.setBoxSize("art", new Rectangle(36, 54, 559, 788));
    writer.setPageEvent(event);
    return writer;
}