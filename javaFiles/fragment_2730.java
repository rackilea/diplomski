public void valueChanged(TreeSelectionEvent e) {
    DefaultMutableTreeNode node = (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();

    mapPanel = drawOpenStreetMap(45, 65, 12);
    rightPanel.add(mapPanel); // rightPanel is the panel in the right side of split pane.
    ...