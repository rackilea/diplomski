PdfReader pdfReader = new PdfReader(SOURCE);
PdfStamper pdfStamper = new PdfStamper(pdfReader, TARGET);
pdfStamper.setRotateContents(false);
for (int page = 1; page <= pdfReader.getNumberOfPages(); page++) {
    Rectangle pageSize = pdfReader.getPageSize(page);
    PdfShading axial = PdfShading.simpleAxial(pdfStamper.getWriter(),
            pageSize.getLeft(pageSize.getWidth()/10), pageSize.getBottom(),
            pageSize.getRight(pageSize.getWidth()/10), pageSize.getBottom(),
            new BaseColor(255, 200, 200), new BaseColor(200, 255, 200), true, true);
    PdfContentByte canvas = pdfStamper.getUnderContent(page);
    canvas.paintShading(axial);
}
pdfStamper.close();