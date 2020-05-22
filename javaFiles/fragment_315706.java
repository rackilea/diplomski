public List<String> prepareFont(PDDocument _pdfDocument, List<PDFont> fonts) throws IOException
{
    PDDocumentCatalog docCatalog = _pdfDocument.getDocumentCatalog();
    PDAcroForm acroForm = docCatalog.getAcroForm();

    PDResources res = acroForm.getDefaultResources();
    if (res == null)
        res = new PDResources();

    List<String> fontNames = new ArrayList<String>();
    for (PDFont font: fonts)
    {
        fontNames.add(res.addFont(font));
    }

    acroForm.setDefaultResources(res);

    return fontNames;
}

public PDFont loadTrueTypeFont(PDDocument _pdfDocument, String resourceName) throws IOException
{
    try ( InputStream fontStream = getClass().getResourceAsStream(resourceName); )
    {
        return PDTrueTypeFont.loadTTF(_pdfDocument, fontStream);
    }
}