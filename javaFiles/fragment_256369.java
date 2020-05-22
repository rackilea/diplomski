public void manipulatePdf(String src, String dest) throws IOException, DocumentException {
    PdfReader reader = new PdfReader(src);
    PdfStamper stamper = new PdfStamper(reader, new FileOutputStream(dest));
    int n = reader.getNumberOfPages();
    PdfDictionary page;
    PdfArray crop;
    PdfArray media;
    for (int p = 1; p <= n; p++) {
        page = reader.getPageN(p);
        media = page.getAsArray(PdfName.CROPBOX);
        if (media == null) {
            media = page.getAsArray(PdfName.MEDIABOX);
        }
        crop = new PdfArray();
        crop.add(new PdfNumber(0));
        crop.add(new PdfNumber(0));
        crop.add(new PdfNumber(media.getAsNumber(2).floatValue() / 2));
        crop.add(new PdfNumber(media.getAsNumber(3).floatValue() / 2));
        page.put(PdfName.MEDIABOX, crop);
        page.put(PdfName.CROPBOX, crop);
        stamper.getUnderContent(p).setLiteral("\nq 0.5 0 0 0.5 0 0 cm\nq\n");
        stamper.getOverContent(p).setLiteral("\nQ\nQ\n");
    }
    stamper.close();
    reader.close();
}