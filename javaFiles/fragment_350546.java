public void extractPatternImages(PDDocument document, String fileNameFormat) throws IOException
{
    List<PDPage> pages = document.getDocumentCatalog().getAllPages();
    if (pages == null)
        return;

    for (int i = 0; i < pages.size(); i++)
    {
        String pageFormat = String.format(fileNameFormat, "-" + i + "%s", "%s");
        extractPatternImages(pages.get(i), pageFormat);
    }
}

public void extractPatternImages(PDPage page, String pageFormat) throws IOException
{
    PDResources resources = page.getResources();
    if (resources == null)
        return;
    Map<String, PDPatternResources> patterns = resources.getPatterns();

    for (Map.Entry<String, PDPatternResources> patternEntry : patterns.entrySet())
    {
        String patternFormat = String.format(pageFormat, "-" + patternEntry.getKey() + "%s", "%s");
        extractPatternImages(patternEntry.getValue(), patternFormat);
    }
}

public void extractPatternImages(PDPatternResources pattern, String patternFormat) throws IOException
{
    COSDictionary resourcesDict = (COSDictionary) pattern.getCOSDictionary().getDictionaryObject(COSName.RESOURCES);
    if (resourcesDict == null)
        return;
    PDResources resources = new PDResources(resourcesDict);
    Map<String, PDXObject> xObjects = resources.getXObjects();
    if (xObjects == null)
        return;

    for (Map.Entry<String, PDXObject> entry : xObjects.entrySet())
    {
        PDXObject xObject = entry.getValue();
        String xObjectFormat = String.format(patternFormat, "-" + entry.getKey() + "%s", "%s");
        if (xObject instanceof PDXObjectForm)
            extractPatternImages((PDXObjectForm)xObject, xObjectFormat);
        else if (xObject instanceof PDXObjectImage)
            extractPatternImages((PDXObjectImage)xObject, xObjectFormat);
    }
}

public void extractPatternImages(PDXObjectForm form, String imageFormat) throws IOException
{
    PDResources resources = form.getResources();
    if (resources == null)
        return;
    Map<String, PDXObject> xObjects = resources.getXObjects();
    if (xObjects == null)
        return;

    for (Map.Entry<String, PDXObject> entry : xObjects.entrySet())
    {
        PDXObject xObject = entry.getValue();
        String xObjectFormat = String.format(imageFormat, "-" + entry.getKey() + "%s", "%s");
        if (xObject instanceof PDXObjectForm)
            extractPatternImages((PDXObjectForm)xObject, xObjectFormat);
        else if (xObject instanceof PDXObjectImage)
            extractPatternImages((PDXObjectImage)xObject, xObjectFormat);
    }

    Map<String, PDPatternResources> patterns = resources.getPatterns();

    for (Map.Entry<String, PDPatternResources> patternEntry : patterns.entrySet())
    {
        String patternFormat = String.format(imageFormat, "-" + patternEntry.getKey() + "%s", "%s");
        extractPatternImages(patternEntry.getValue(), patternFormat);
    }
}

public void extractPatternImages(PDXObjectImage image, String imageFormat) throws IOException
{
    image.write2OutputStream(new FileOutputStream(String.format(imageFormat, "", image.getSuffix())));
}