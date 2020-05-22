class RoundRectangle implements PdfPCellEvent {
    public void cellLayout(PdfPCell cell, Rectangle rect,
            PdfContentByte[] canvas) {
        PdfContentByte cb = canvas[PdfPTable.LINECANVAS];
        cb.roundRectangle(
            rect.getLeft() + 1.5f, rect.getBottom() + 1.5f, rect.getWidth() - 3,
            rect.getHeight() - 3, 4);
        cb.stroke();
    }
}