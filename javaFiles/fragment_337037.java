public void removeHighlights(JTextComponent c, String toBlackOut) {
    Highlighter highlighter = c.getHighlighter();
    Highlighter.Highlight[] highlights = h.getHighlights();
    Document d = c.getDocument();
    for (Highlighter.Highlight h : highlights)
        if (highlightedText(h, d).equals(toBlackOut) && h.getPainter() instanceof TextHighLighter)
            highlighter.removeHighlight(h);
}