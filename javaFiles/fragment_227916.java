public void tableLayout(PdfPTable table, float[][] width, float[] height,
        int headerRows, int rowStart, PdfContentByte[] canvas) {
    float widths[] = width[0];
    float x1 = widths[0];
    float x2 = widths[widths.length - 1];
    float y = height[height.length - 1];
    PdfContentByte cb = canvas[PdfPTable.LINECANVAS];
    cb.moveTo(x1, y);
    cb.lineTo(x2, y);
    cb.stroke();
}