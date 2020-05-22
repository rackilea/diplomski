public ColumnText createColumn(PdfContentByte cb, int i, String la, Rectangle rect)
    throws IOException {
    ColumnText ct = new ColumnText(cb);
    ct.setSimpleColumn(rect);
    Phrase p = createPhrase(String.format("resources/text/liber1_%s_%s.txt", i, la));
    ct.addText(p);
    return ct;
}