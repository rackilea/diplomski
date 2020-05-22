jZoomPanel.addMouseWheelListener(new MouseWheelListener() {

    @Override
    public void mouseWheelMoved(MouseWheelEvent e) {
        if(e.isControlDown()) {
        // TODO implement zoom
        } else {
            JPanel panel = (JPanel) me.getSource();
            MouseEvent newMe = SwingUtilities.convertMouseEvent(panel, me, jsc);
            jsc.dispatchEvent(me);
        }
    }
});