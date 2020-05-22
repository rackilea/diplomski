private static final float FOOTER_MARGIN = 15;
private static final float PAGE_MARGIN_LEFT = 36;
private static final float PAGE_MARGIN_RIGHT = 36;
private static final float PAGE_MARGIN_BOTTOM = 36 + FOOTER_MARGIN;
private static final float PAGE_MARGIN_TOP = 36;
private static final Rectangle PAGE_SIZE = PageSize.A4;

//Put this in your generator method
//..
Document document = new Document(PAGE_SIZE, 
         PAGE_MARGIN_LEFT, PAGE_MARGIN_RIGHT, PAGE_MARGIN_BOTTOM, MARGIN_TOP); 
PdfWriter writer = PdfWriter.getInstance(document, OUTPUT_STREAM); 
writer.setPageEvent(new HeaderFooter()); 
//..

private class HeaderFooter extends PdfPageEventHelper {

    @Override
    public void onEndPage(PdfWriter writer, Document document) {
        Phrase footerText = new Phrase("Continued On Next Page");
        ColumnText.showTextAligned(
                writer.getDirectContent(),
                Element.ALIGN_LEFT, footerText,
                PAGE_MARGIN_LEFT, PAGE_MARGIN_BOTTOM - FOOTER_MARGIN, 0);
    }
}