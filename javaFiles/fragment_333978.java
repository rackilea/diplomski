private synchronized JPanel getInnerPanel() {
    if(innerPanel == null) {
        innerPanel = new JPanel();
    }
    return innerPanel;
}