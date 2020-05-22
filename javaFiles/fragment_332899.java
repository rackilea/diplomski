public void paint(Graphics g) {
    // PENDING(prinz) - should cull ranges not visible
    int len = highlights.size();
    for (int i = 0; i < len; i++) {
        HighlightInfo info = highlights.elementAt(i);
        if (!(info instanceof LayeredHighlightInfo)) {
            // Avoid allocing unless we need it.
            Rectangle a = component.getBounds();
            Insets insets = component.getInsets();
            a.x = insets.left;
            a.y = insets.top;
            a.width -= insets.left + insets.right;
            a.height -= insets.top + insets.bottom;
            for (; i < len; i++) {
                info = highlights.elementAt(i);
                if (!(info instanceof LayeredHighlightInfo)) {
                    Highlighter.HighlightPainter p = info.getPainter();
                    p.paint(g, info.getStartOffset(), info.getEndOffset(),
                            a, component);
                }
            }
        }
    }
}