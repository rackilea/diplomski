pf.addAncestorListener(new AncestorListener() {     

    public void ancestorRemoved(AncestorEvent event) {}

    public void ancestorMoved(AncestorEvent event) {}            

    public void ancestorAdded(final AncestorEvent event) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                event.getComponent().requestFocusInWindow();
                event.getComponent().removeAncestorListener(this);
            }
        });
    }
});