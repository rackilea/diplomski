class DottedCell implements PdfPCellEvent {
    @Override
    public void cellLayout(PdfPCell cell, Rectangle position,
        PdfContentByte[] canvases) {
        PdfContentByte canvas = canvases[PdfPTable.LINECANVAS];
        canvas.setLineDash(3f, 3f);
        canvas.rectangle(position.getLeft(), position.getBottom(),
            position.getWidth(), position.getHeight());
        canvas.stroke();
    }
}