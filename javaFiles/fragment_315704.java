public String prepareFont(PDDocument _pdfDocument) throws IOException
{
    PDDocumentCatalog docCatalog = _pdfDocument.getDocumentCatalog();
    PDAcroForm acroForm = docCatalog.getAcroForm();

    PDResources res = acroForm.getDefaultResources();
    if (res == null)
        res = new PDResources();

    InputStream fontStream = getClass().getResourceAsStream("LiberationSans-Regular.ttf");
    PDTrueTypeFont font = PDTrueTypeFont.loadTTF(_pdfDocument, fontStream);
    String fontName = res.addFont(font);
    acroForm.setDefaultResources(res);

    return fontName;
}