JViewport viewport = new JViewport();
viewport.setView(label);
viewport.addComponentListener(new ComponentAdapter() {
    @Override
    public void componentResized(ComponentEvent event) {
        int width = viewport.getWidth();
        Dimension size = label.getPreferredSize();
        viewport.setViewPosition(new Point(size.width - width, 0));
    }
});