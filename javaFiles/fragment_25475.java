frame.addComponentListener(new ComponentListener() {

    @Override
    public void componentHidden(ComponentEvent arg0) {
    }

    @Override
    public void componentMoved(ComponentEvent arg0) {
    }

    @Override
    public void componentResized(ComponentEvent arg0) {
        System.out.println(frame.getSize());
    }

    @Override
    public void componentShown(ComponentEvent e) {

    }
});