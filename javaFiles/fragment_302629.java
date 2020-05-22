RegexBasedLocationExtractionStrategy evntlstnr = new RegexBasedLocationExtractionStrategy(pattern);
for (int pIdx = 0; pIdx < pdfDoc.getNumberOfPages(); ++pIdx) {
    final PdfPage page = pdfDoc.getPage(pIdx + 1);
    new PdfCanvasProcessor(evntlstnr).processPageContent(page);
    Collection<IPdfTextLocation> locations =  evntlstnr.getResultantLocations();
    for (IPdfTextLocation location : locations) {
        Rectangle rect = location.getRectangle();
        // Specify quad points in Z-like order
        // [0,1] x1,y1   [2,3] x2,y2
        // [4,5] x3,y3   [6,7] x4,y4
        float[] quads = new float[8];
        quads[0] = rect.getX();
        quads[1] = rect.getY() + rect.getHeight();
        quads[2] = rect.getX() + rect.getWidth();
        quads[3] = quads[1];
        quads[4] = quads[0];
        quads[5] = rect.getY();
        quads[6] = quads[2];
        quads[7] = quads[5];

        Color highlightColor = new DeviceRgb(1f, 1f, 0f);                                                                                                                           

        PdfTextMarkupAnnotation highlight = PdfTextMarkupAnnotation.createHighLight(rect, quads);
        highlight.setColor(highlightColor); 
        highlight.setFlag(PdfAnnotation.PRINT);
        page.addAnnotation(highlight);                            

        PdfCanvas canvas = new PdfCanvas(page);
        PdfExtGState extGState = new PdfExtGState();
        extGState.setBlendMode(PdfExtGState.BM_MULTIPLY);
        canvas.setExtGState(extGState);
        canvas.rectangle(rect.getX(), rect.getY(), rect.getWidth(), rect.getHeight());
        canvas.setFillColor(highlightColor);
        canvas.fill();                            
        canvas.release();                                                        
    }
}