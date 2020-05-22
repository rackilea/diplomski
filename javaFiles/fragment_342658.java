class MyPdfPTableEvent implements PdfPTableEvent {

    public void cellLayout(PdfPCell cell, Rectangle position, PdfContentByte[] canvases) {
    }

    public void tableLayout(PdfPTable table, float[][] widths, float[] heights, int headerRows, int rowStart, PdfContentByte[] canvases) {
        ColumnText ct = new ColumnText(canvases[PdfPTable.TEXTCANVAS]);
        for (int i = 1; i < widths[1].length; i++) {
            Rectangle position = new Rectangle(widths[1][i - 1], heights[1], widths[1][i], heights[2]);
            ct.setSimpleColumn(position);
            ct.addText(new Phrase("This inner table header will always be repeated"));
            try {
                ct.go();
            } catch (DocumentException ex) {
            }
        }
    }
}