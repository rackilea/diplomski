private static String highlightedText(Highlight h, Document d) {
    int start = h.getStartIndex();
    int end = h.getEndIndex();
    int length = end - start;
    return d.getText(start, length);
}