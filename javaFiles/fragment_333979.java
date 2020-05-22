private JPanel getInnerPanel() {
    synchronized(innerPanel) {
        if(innerPanel == null) {
            innerPanel = new JPanel();
        }
    }
    return innerPanel;
}