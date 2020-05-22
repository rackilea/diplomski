File outputPdf = File.createTempFile("moveMediabox", ".pdf");
 PdfReader reader = new PdfReader(ByteSource.wrap(inputPdfBytes).openBufferedStream());
 PdfStamper stamper = new PdfStamper(reader, new FileOutputStream(outputPdf));
 int numberOfPages = reader.getNumberOfPages();

 for (int i = 1; i <= numberOfPages; i++) {
        PdfDictionary pagedict = reader.getPageN(i);
        PdfArray mediabox = pagedict.getAsArray(PdfName.MEDIABOX);
        int x = mediabox.getAsNumber(0).intValue();
        int y = mediabox.getAsNumber(1).intValue();
        if (x != 0 && y != 0){
            isChanged = true;
            mediabox.set(0, new PdfNumber(0));
            mediabox.set(1, new PdfNumber(0));
            mediabox.set(2, new PdfNumber(mediabox.getAsNumber(2).intValue() - x));
            mediabox.set(3, new PdfNumber(mediabox.getAsNumber(3).intValue() - y)); 
        }
        else{
            LOG.info("no need to repair media box, already at x:0 y:0");
        }
    }