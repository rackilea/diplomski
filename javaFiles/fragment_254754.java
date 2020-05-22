class DottedCells implements PdfPTableEvent {
    @Override
    public void tableLayout(PdfPTable table, float[][] widths,
        float[] heights, int headerRows, int rowStart,
        PdfContentByte[] canvases) {
        PdfContentByte canvas = canvases[PdfPTable.LINECANVAS];
        canvas.setLineDash(3f, 3f);
        float llx = widths[0][0];
        float urx = widths[0][widths[0].length -1];
        for (int i = 0; i < heights.length; i++) {
            canvas.moveTo(llx, heights[i]);
            canvas.lineTo(urx, heights[i]);
        }
        for (int i = 0; i < widths.length; i++) {
            for (int j = 0; j < widths[i].length; j++) {
                canvas.moveTo(widths[i][j], heights[i]);
                canvas.lineTo(widths[i][j], heights[i+1]);
            }
        }
        canvas.stroke();
    }
}