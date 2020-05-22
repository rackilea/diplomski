float factor = 2.5f;
PdfReader reader = new PdfReader(src);
int n = reader.getNumberOfPages();
PdfDictionary page;
for (int p = 1; p <= n; p++) {
    page = reader.getPageN(p);
    if (page.getAsNumber(PdfName.USERUNIT) == null)
        page.put(PdfName.USERUNIT, new PdfNumber(factor));
}
PdfStamper stamper = new PdfStamper(reader, new FileOutputStream(dest));
stamper.close();
reader.close();