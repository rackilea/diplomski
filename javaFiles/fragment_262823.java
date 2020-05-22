PDFormXObject importAsXObject(PDDocument target, PDPage page) throws IOException
{
    final PDStream src = page.getContents();
    if (src != null)
    {
        final PDFormXObject xobject = new PDFormXObject(target);

        OutputStream os = xobject.getPDStream().createOutputStream();
        InputStream is = src.createInputStream();
        try
        {
            IOUtils.copy(is, os);
        }
        finally
        {
            IOUtils.closeQuietly(is);
            IOUtils.closeQuietly(os);
        }

        xobject.setResources(page.findResources());
        xobject.setBBox(page.findCropBox());

        return xobject;
    }
    return null;
}