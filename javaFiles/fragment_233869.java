JPopupMenu popup = new JPopupMenu();
popup.add(makeMenuItem("menuitem1"));

private JMenuItem makeMenuItem(String label) {
    JMenuItem item = new JMenuItem(label);
    item.addActionListener(this);
    return item;
}