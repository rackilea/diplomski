ChangeListener l = new ChangeListener() {

    Component lastSelected = tabbedPane.getSelectedComponent();
    @Override
    public void stateChanged(ChangeEvent e) {
        if (lastSelected != tabbedPane.getSelectedComponent()) {
            LOG.info("changed: " + tabbedPane.getSelectedIndex());
            lastSelected = tabbedPane.getSelectedComponent();
        }

    }
};
tabbedPane.addChangeListener(l);