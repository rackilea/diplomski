//get the container
Container tempContainer = MetricTablesX.this.getTopLevelAncestor();
if (tempContainer == null || tempContainer.getComponentCount() == 0) {
    return;
}

//get the root pane
Component rootPane = tempContainer.getComponent(0);
if (rootPane == null || !(rootPane instanceof JRootPane)) {
    return;
}
JRootPane pane = (JRootPane) rootPane;
if (pane == null || pane.getComponentCount() == 0) {
    return;
}

//get the layer Pane
Component jLayerPane = pane.getComponent(1);
if (jLayerPane == null || !(jLayerPane instanceof JLayeredPane)) {
    return;
}
JLayeredPane layerPane = (JLayeredPane) jLayerPane;
if (layerPane == null || layerPane.getComponentCount() == 0) {
    return;
}

//get the junk panel
Component jPanel = layerPane.getComponent(0);
if (jPanel == null || !(jPanel instanceof JPanel)) {
    return;
}
JPanel junkPanel = (JPanel) jPanel;
if (junkPanel == null || junkPanel.getComponentCount() == 0) {
    return;
}

//get the main panel
Component mPanel = junkPanel.getComponent(0);
if (mPanel == null || !(mPanel instanceof JPanel)) {
    return;
}
JPanel mainPanel = (JPanel) mPanel;
if (mainPanel == null || mainPanel.getComponentCount() == 0) {
    return;
}

//get the dashHolder
for (int i = 0; i < mainPanel.getComponentCount(); i++) {
    Component dPanel = mainPanel.getComponent(i);
    if (dPanel == null || !(dPanel instanceof JPanel)) {
        return;
    }
    JPanel dashHolderPanel = (JPanel) dPanel;
    if (dashHolderPanel.getName().equalsIgnoreCase("dashHolderPanel")) {
        RetailRegionDashboard retailRegionDash = new RetailRegionDashboard(cell.mtr);
        dashHolderPanel.removeAll();
        dashHolderPanel.add(retailRegionDash);
        dashHolderPanel.revalidate();
        dashHolderPanel.repaint();
    }
}