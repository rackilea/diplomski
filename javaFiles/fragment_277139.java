class ShadowEvent extends PdfPageEventHelper {
    @Override
    public void onGenericTag(PdfWriter writer, Document document,
      Rectangle rect, String text) {
        PdfContentByte canvas = writer.getDirectContent();
        // Paddings for the border
        int paddingHorizontal = 20;
        int paddingVertical = 5;
        // Width of the shadow
        int shadowwidth = 5;
        // Calculate border location and size
        float left = rect.getLeft() - paddingHorizontal;
        float bottom = rect.getBottom() - paddingVertical;
        float width = rect.getWidth() + 2*paddingHorizontal;
        float height = rect.getHeight() + 2*paddingVertical;
        canvas.saveState();
        canvas.setColorFill(BaseColor.GRAY);
        // Draw the shadow at the bottom
        canvas.rectangle(left + shadowwidth, bottom - shadowwidth, width, shadowwidth);
        canvas.fill();
        // Draw the shadow at the right
        canvas.rectangle(left + width, bottom - shadowwidth, shadowwidth, height);
        canvas.fill();
        canvas.setColorStroke(BaseColor.BLACK);
        // Draw the border
        canvas.rectangle(left, bottom, width, height);
        canvas.stroke();
        canvas.restoreState();
    }
}