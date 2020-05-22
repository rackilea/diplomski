String prefix = new File(pdfFilename).getName();
    prefix = prefix.substring(0, prefix.indexOf(".pdf"));

    PDDocument document = null;

    try
    {
        document = PDDocument.loadNonSeq(new(pdfFilename), null); // use non-seq parser is better

        List<PDPage> pages = document.getDocumentCatalog().getAllPages();
        System.out.println(pdfFilename + ": Total pages: " + pages.size());
        int p = 0;
        for (PDPage page : pages)
        {
            ++p;
            PDResources resources = page.getResources();
            Map<String, PDXObjectImage> imageResources = resources.getImages();
            for (String key : imageResources.keySet())
            {
                PDXObjectImage objectImage = imageResources.get(key);
                System.out.printf("image key '%s': %d x %d, type %s%n", key, objectImage.getHeight(), objectImage.getWidth(), objectImage.getSuffix());

                // write that image
                String fname = String.format("%s-%04d-%s", prefix, p, key);
                objectImage.write2file(fname);
            }
        }
    }
    // put catch here
    document.close();