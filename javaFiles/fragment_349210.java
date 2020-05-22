final MouseWheelListener wheel = new MouseWheelListener() {

    @Override
    public void mouseWheelMoved(MouseWheelEvent e) {
        // handle some events here and dispatch others
        if (shouldHandleHere(e)) {
            LOG.info("do-my-own-stuff");
        } else {
            LOG.info("dispatch-to-parent");
            e.getComponent().getParent().dispatchEvent(e);
        } 
    }

    public boolean shouldHandleHere(MouseWheelEvent e) {
        return (e.getModifiersEx() & InputEvent.CTRL_DOWN_MASK) != 0;
    }
};