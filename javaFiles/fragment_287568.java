private class Listener implements AncestorAdapter {

    @Override
    public void ancestorMoved(ComponentEvent e) {
        if (e.getComponent().equals(target)) {
            targetMoved();
        } else {
            stickyMoved();
        }
    }
}