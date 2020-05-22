private static void drawTableAtTheEndOfPage(Document document, PdfWriter writer, PdfPTable datatable)
{
    datatable.setTotalWidth(document.right() - document.left());

    datatable.writeSelectedRows(0, -1, document.left(),
            datatable.getTotalHeight() + document.bottom(), writer.getDirectContent());
}