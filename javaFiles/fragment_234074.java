if (area.getPageNumber() == lastPage) {
    PdfDocumentContentParser parser = new PdfDocumentContentParser(doc.getPdfDocument());
    TextMarginFinder finder = parser.processContent(lastPage, new TextMarginFinder());
    area.getBBox().decreaseHeight(finder.getTextRectangle().getHeight() + 30);
} else if (area.getPageNumber() < lastPage){
    area.getBBox().decreaseHeight(doc.getPdfDocument().getDefaultPageSize().getHeight());
}
return area;