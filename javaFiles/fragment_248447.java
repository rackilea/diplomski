class PressPreview implements PdfPCellEvent {

    public BaseFont bf;

    public PressPreview() throws DocumentException, IOException {
        bf = BaseFont.createFont();
    }

    public void cellLayout(PdfPCell cell, Rectangle rect,
            PdfContentByte[] canvas) {
        PdfContentByte cb = canvas[PdfPTable.TEXTCANVAS];
        cb.beginText();
        cb.setFontAndSize(bf, 12);
        cb.showTextAligned(Element.ALIGN_RIGHT, "PRESS PREVIEW",
            rect.getRight() - 3, rect.getBottom() + 4.5f, 0);
        cb.endText();
    }
}