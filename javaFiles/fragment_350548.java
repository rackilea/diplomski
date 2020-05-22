public void extractPatternImages(PDDocument document, String fileNameFormat) throws IOException
{
    PDPageTree pages = document.getDocumentCatalog().getPages();
    if (pages == null)
        return;

    for (int i = 0; i < pages.getCount(); i++)
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
    Iterable<COSName> patternNames = resources.getPatternNames();

    for (COSName patternName : patternNames)
    {
        String patternFormat = String.format(pageFormat, "-" + patternName + "%s", "%s");
        extractPatternImages(resources.getPattern(patternName), patternFormat);
    }
}

public void extractPatternImages(PDAbstractPattern pattern, String patternFormat) throws IOException
{
    COSDictionary resourcesDict = (COSDictionary) pattern.getCOSObject().getDictionaryObject(COSName.RESOURCES);
    if (resourcesDict == null)
        return;
    PDResources resources = new PDResources(resourcesDict);
    Iterable<COSName> xObjectNames = resources.getXObjectNames();
    if (xObjectNames == null)
        return;

    for (COSName xObjectName : xObjectNames)
    {
        PDXObject xObject = resources.getXObject(xObjectName);
        String xObjectFormat = String.format(patternFormat, "-" + xObjectName + "%s", "%s");
        if (xObject instanceof PDFormXObject)
            extractPatternImages((PDFormXObject)xObject, xObjectFormat);
        else if (xObject instanceof PDImageXObject)
            extractPatternImages((PDImageXObject)xObject, xObjectFormat);
    }
}

public void extractPatternImages(PDFormXObject form, String imageFormat) throws IOException
{
    PDResources resources = form.getResources();
    if (resources == null)
        return;
    Iterable<COSName> xObjectNames = resources.getXObjectNames();
    if (xObjectNames == null)
        return;

    for (COSName xObjectName : xObjectNames)
    {
        PDXObject xObject = resources.getXObject(xObjectName);
        String xObjectFormat = String.format(imageFormat, "-" + xObjectName + "%s", "%s");
        if (xObject instanceof PDFormXObject)
            extractPatternImages((PDFormXObject)xObject, xObjectFormat);
        else if (xObject instanceof PDImageXObject)
            extractPatternImages((PDImageXObject)xObject, xObjectFormat);
    }

    Iterable<COSName> patternNames = resources.getPatternNames();

    for (COSName patternName : patternNames)
    {
        String patternFormat = String.format(imageFormat, "-" + patternName + "%s", "%s");
        extractPatternImages(resources.getPattern(patternName), patternFormat);
    }
}

public void extractPatternImages(PDImageXObject image, String imageFormat) throws IOException
{
    String filename = String.format(imageFormat, "", image.getSuffix());
    ImageIOUtil.writeImage(image.getOpaqueImage(), "png", new FileOutputStream(filename));
}