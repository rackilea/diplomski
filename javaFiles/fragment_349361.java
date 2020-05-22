textArea.addCaretListener(new CaretListener() {
        @Override
        public void caretUpdate(CaretEvent e) {
            int startLine = getLine(e.getDot());
            int endLine = getLine(e.getMark());
            ...
        }
    });

private int getLine(int offset) {
    String text = textArea.getDocument().getText(0, offset);
    int linenr = 0;
    int idx = text.indexOf("\n");
    while (idx != -1) {
        linenr++;
        idx = text.indexOf("\n", idx);
    }
    return linenr;
}