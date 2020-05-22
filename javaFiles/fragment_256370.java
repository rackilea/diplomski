public void manipulatePdf(String src, String dest) throws IOException, DocumentException {
    PdfReader reader = new PdfReader(src);
    PdfStamper stamper = new PdfStamper(reader, new FileOutputStream(dest));
    int n = reader.getNumberOfPages();
    float percentage = 0.8f;
    for (int p = 1; p <= n; p++) {
        float offsetX = (reader.getPageSize(p).getWidth() * (1 - percentage)) / 2;
        float offsetY = (reader.getPageSize(p).getHeight() * (1 - percentage)) / 2;
        stamper.getUnderContent(p).setLiteral(
                String.format("\nq %s 0 0 %s %s %s cm\nq\n", percentage, percentage, offsetX, offsetY));
        stamper.getOverContent(p).setLiteral("\nQ\nQ\n");
    }
    stamper.close();
    reader.close();
}