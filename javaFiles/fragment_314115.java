for (PDPage page : doc.getPages())
{
    PDResources resources = page.getResources();
    if (resources == null)
    {
        continue;
    }
    for (COSName name : resources.getXObjectNames())
    {
        PDXObject xObject = resources.getXObject(name);
        if (xObject instanceof PDImageXObject)
        {
            PDImageXObject img = (PDImageXObject) xObject;
            if (img.getColorSpace() instanceof PDICCBased)
            {
                PDICCBased icc = (PDICCBased) img.getColorSpace();
                if (icc.getNumberOfComponents() == 1 && PDDeviceRGB.INSTANCE.equals(icc.getAlternateColorSpace()))
                {
                    List<PDColorSpace> list = new ArrayList<>();
                    list.add(PDDeviceGray.INSTANCE);
                    icc.setAlternateColorSpaces(list);
                }
            }
        }
    }
}