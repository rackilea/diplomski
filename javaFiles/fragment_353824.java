public class DrawRectangle extends PdfPageEventHelper {

    @Override
    public void onGenericTag(PdfWriter writer, Document document, Rectangle rect, String text) {
        PdfContentByte canvas = writer.getDirectContent();
        canvas.rectangle(rect.getLeft(), rect.getBottom(), rect.getWidth(), rect.getHeight());
        canvas.stroke();
        canvas.restoreState();
    }
}