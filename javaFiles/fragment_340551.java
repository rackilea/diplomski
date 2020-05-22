public void renderImage(ImageRenderInfo renderInfo) {
    List<Rectangle> areasToBeCleaned = getImageAreasToBeCleaned(renderInfo);

    if (areasToBeCleaned == null) {
        chunks.add(new PdfCleanUpContentChunk.Image(false, null));
    } else if ( areasToBeCleaned.size() > 0) {
        try {
            PdfImageObject pdfImage = renderInfo.getImage();
            byte[] imageBytes = processImage(pdfImage.getImageAsBytes(), areasToBeCleaned);

            if (renderInfo.getRef() == null && pdfImage != null) { // true => inline image
                PdfDictionary dict = pdfImage.getDictionary();
                PdfObject imageMask = dict.get(PdfName.IMAGEMASK);
                Image image = Image.getInstance(imageBytes);

                if (imageMask == null) {
                    imageMask = dict.get(PdfName.IM);
                }

                if (imageMask != null && imageMask.equals(PdfBoolean.PDFTRUE)) {
                    image.makeMask();
                }

                PdfContentByte canvas = getContext().getCanvas();
                canvas.addImage(image, 1, 0, 0, 1, 0, 0, true);
            } else if (pdfImage != null && imageBytes != pdfImage.getImageAsBytes()) {
                chunks.add(new PdfCleanUpContentChunk.Image(true, imageBytes));
            }
        } catch (UnsupportedPdfException pdfException) {
            chunks.add(new PdfCleanUpContentChunk.Image(false, null));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    } else { // add inline images not subject to redaction to the content
        try {
            PdfImageObject pdfImage = renderInfo.getImage();
            if (renderInfo.getRef() == null && pdfImage != null) { // true => inline image
                PdfDictionary dict = pdfImage.getDictionary();
                PdfObject imageMask = dict.get(PdfName.IMAGEMASK);
                Image image = Image.getInstance(pdfImage.getImageAsBytes());

                if (imageMask == null) {
                    imageMask = dict.get(PdfName.IM);
                }

                if (imageMask != null && imageMask.equals(PdfBoolean.PDFTRUE)) {
                    image.makeMask();
                }

                PdfContentByte canvas = getContext().getCanvas();
                canvas.addImage(image, 1, 0, 0, 1, 0, 0, true);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}