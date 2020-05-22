PDDocument doc = PDDocument.load(new File("XXXXX.pdf"));
    for (PDOutputIntent oi : doc.getDocumentCatalog().getOutputIntents())
    {
        COSStream destOutputIntent = oi.getDestOutputIntent();
        String info = oi.getOutputCondition();
        if (info == null || info.isEmpty())
        {
            info = oi.getInfo();
        }
        InputStream is = destOutputIntent.createInputStream();
        FileOutputStream fos = new FileOutputStream(info + ".icc");
        IOUtils.copy(is, fos);
        fos.close();
        is.close();
    }
    for (int p = 0; p < doc.getNumberOfPages(); ++p)
    {
        PDPage page = doc.getPage(p);
        for (COSName name : page.getResources().getColorSpaceNames())
        {
            PDColorSpace cs = page.getResources().getColorSpace(name);
            if (cs instanceof PDICCBased)
            {
                PDICCBased iccCS = (PDICCBased) cs;
                InputStream is = iccCS.getPDStream().createInputStream();
                FileOutputStream fos = new FileOutputStream(System.currentTimeMillis() + ".icc");
                IOUtils.copy(is, fos);
                fos.close();
                is.close();
            }
        }
        for (COSName name : page.getResources().getXObjectNames())
        {
            PDXObject x = page.getResources().getXObject(name);
            if (x instanceof PDImageXObject)
            {
                PDImageXObject img = (PDImageXObject) x;
                if (img.getColorSpace() instanceof PDICCBased)
                {
                    InputStream is = ((PDICCBased) img.getColorSpace()).getPDStream().createInputStream();
                    FileOutputStream fos = new FileOutputStream(System.currentTimeMillis() + ".icc");
                    IOUtils.copy(is, fos);
                    fos.close();
                    is.close();
                }
            }
        }
    }
    doc.close();