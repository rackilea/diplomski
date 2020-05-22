spLeft.setWheelScrollingEnabled(false);
spLeft.addMouseWheelListener(new MouseWheelListener() {
    public void mouseWheelMoved(MouseWheelEvent e) {
        spRight.dispatchEvent(e);
    }
});