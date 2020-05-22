textField.addHierarchyListener(new HierarchyListener() {
    @Override
    public void hierarchyChanged(HierarchyEvent e) {
        final Component c = e.getComponent();
        long flags = e.getChangeFlags();
        if ((flags & HierarchyEvent.SHOWING_CHANGED) != 0 &&
                c.isShowing()) {

            EventQueue.invokeLater(new Runnable() {
                @Override
                public void run() {
                    c.requestFocusInWindow();
                }
            });
        }
    }
});