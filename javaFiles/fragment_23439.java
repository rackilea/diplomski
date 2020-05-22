static void updateMargin(JTextPane textPane) {
    JViewport viewport = (JViewport)
        SwingUtilities.getAncestorOfClass(JViewport.class, textPane);

    if (viewport != null) {
        Insets margin = textPane.getMargin();

        int len = textPane.getDocument().getLength();
        try {
            Rectangle end = textPane.modelToView(len);
            if (end != null) {
                margin.bottom = viewport.getHeight() - end.height;
                textPane.setMargin(margin);
            }
        } catch (BadLocationException e) {
            throw new RuntimeException(e);
        }
    }
}