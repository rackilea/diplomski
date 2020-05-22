jsp.addComponentListener(new ComponentListener() {
    @Override
    public void componentShown(ComponentEvent e) {}

    @Override
    public void componentResized(ComponentEvent e) {
        Dimension jspSize = ((JScrollPane)e.getComponent()).getViewport().getSize();
        jep.setBounds(0, 0, jspSize.width, jspSize.height);
    }

    @Override
    public void componentMoved(ComponentEvent e) {}

    @Override
    public void componentHidden(ComponentEvent e) {}
});