public void popupMenuWillBecomeVisible(PopupMenuEvent e) {
    JComboBox box = (JComboBox) e.getSource();
    Object comp = box.getUI().getAccessibleChild(box, 0);
    if (!(comp instanceof JPopupMenu)) return;
    JComponent scrollPane = (JComponent) ((JPopupMenu) comp).getComponent(0);
    Dimension size = new Dimension();
    size.width = box.getPreferredSize().width;
    size.height = scrollPane.getPreferredSize().height;
    scrollPane.setPreferredSize(size);
    //  following line for Tiger
    // scrollPane.setMaximumSize(size);
}