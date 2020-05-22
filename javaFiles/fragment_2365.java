JTextPane editor = new JTextPane();
DefaultCaret dc = new DefaultCaret() {
    @Override
    public void paint(Graphics g) {

        if (isVisible()) {

            JTextComponent comp = getComponent();
            if (comp == null) {
                return;
            }

            Rectangle r = null;
            try {
                r = comp.modelToView(getDot());
                if (r == null) {
                    return;
                }
            } catch (BadLocationException e) {
                return;
            }
            if (isVisible()) {
                g.fillRect(r.x, r.y + 2, 1, r.height - 2);
            }
        }
    }
};
dc.setBlinkRate(500);
editor.setCaret(dc);