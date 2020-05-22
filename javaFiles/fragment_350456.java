List<PDPage> pages = document.getDocumentCatalog().getAllPages();
    for(PDPage page : pages) {
        Map<String, PDXObjectImage> images = page.getResources().getImages();

        for(PDXObjectImage image : images.values()){
            //TODO: write image to disk
        }   
    }