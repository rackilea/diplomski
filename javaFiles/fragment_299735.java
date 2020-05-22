public void componentAdded(ContainerEvent added) {
    updateTabs();
}

public void updateTabs() {
    for (int i = 0; i < tabbedPane.getComponents().length; i++) {
        tabbedPane.setTitleAt(i,
                tabbedPane.getComponents()[i].getName());
    }
}