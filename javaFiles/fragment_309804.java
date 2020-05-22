public String cropPdf(String pdfFilePath) throws DocumentException, IOException {
    String filename = FilenameUtils.getBaseName(pdfFilePath) + "_cropped." + FilenameUtils.getExtension(pdfFilePath);
    filename = FilenameUtils.concat(System.getProperty("java.io.tmpdir"), filename);
    PdfReader reader = new PdfReader(pdfFilePath);
    try {
        PdfStamper stamper = new PdfStamper(reader, new FileOutputStream(filename));
        try {
            for (int i = 1; i <= reader.getNumberOfPages(); i++) {
                PdfDictionary pdfDictionary = reader.getPageN(i);
                PdfArray cropArray = new PdfArray();
                Rectangle cropbox = reader.getCropBox(i);                   
                cropArray.add(new PdfNumber(cropbox.getLeft()));
                cropArray.add(new PdfNumber(cropbox.getBottom()));
                cropArray.add(new PdfNumber(cropbox.getLeft() + cropbox.getWidth()));
                cropArray.add(new PdfNumber(cropbox.getBottom() + cropbox.getHeight()));
                pdfDictionary.put(PdfName.CROPBOX, cropArray);
                pdfDictionary.put(PdfName.MEDIABOX, cropArray);
                pdfDictionary.put(PdfName.TRIMBOX, cropArray);
                pdfDictionary.put(PdfName.BLEEDBOX, cropArray);
            }
            return filename;
        } finally {
            stamper.close();
        }
    } finally {
        reader.close();
    }
}