public class Background extends PdfPageEventHelper {
    @Override
    public void onEndPage(PdfWriter writer, Document document) {
        int pagenumber = writer.getPageNumber();
        if (pagenumber % 2 == 1 && pagenumber != 1)
            return;
        PdfContentByte canvas = writer.getDirectContentUnder();
        Rectangle rect = document.getPageSize();
        canvas.setColorFill(pagenumber < 3 ? BaseColor.BLUE : BaseColor.LIGHT_GRAY);
        canvas.rectangle(rect.getLeft(), rect.getBottom(), rect.getWidth(), rect.getHeight());
        canvas.fill();
    }
}