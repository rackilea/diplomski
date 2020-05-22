public class Rotate extends PdfPageEventHelper {
    protected PdfNumber rotation = PdfPage.PORTRAIT;
    public void setRotation(PdfNumber rotation) {
        this.rotation = rotation;
    }
    public void onEndPage(PdfWriter writer, Document document) {
        writer.addPageDictEntry(PdfName.ROTATE, rotation);
    }
}