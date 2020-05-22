addMouseWheelListener(new MouseWheelListener() {

    @Override
    public void mouseScrolled(MouseEvent g) {
        if((g.stateMask & SWT.CONTROL) == SWT.CONTROL) {
            performZoom(g.count);
        }
    }
});