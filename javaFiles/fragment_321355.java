private DefaultHighlighter.DefaultHighlightPainter highlightPainter;
//...
highlightPainter = new DefaultHighlighter.DefaultHighlightPainter(UIManager.getColor("TextArea.selectionBackground"));

left.getCaret().addChangeListener(new ChangeListener() {
    @Override
    public void stateChanged(ChangeEvent e) {
        int dot = left.getCaret().getDot();
        int mark = left.getCaret().getMark();

        right.getHighlighter().removeAllHighlights();
        try {
            int start = Math.min(dot, mark);
            int end = Math.max(dot, mark);
            right.getHighlighter().addHighlight(start, end, highlightPainter);
        } catch (BadLocationException ex) {
            ex.printStackTrace();
        }
    }
});