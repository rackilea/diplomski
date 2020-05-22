final JSplitPane left = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
final JSplitPane right = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
left.setDividerLocation(0.3);
right.setDividerLocation(0.3);
left.setLeftComponent(scrollPane1);
right.setLeftComponent(scrollPane2);
right.setRightComponent(scrollPane3);
left.setRightComponent(right);
add(left, BorderLayout.CENTER);
add(status, BorderLayout.PAGE_END);
setVisible(true);
right.addComponentListener(new ComponentAdapter() {
    @Override
    public void componentResized(ComponentEvent e) {
        right.setResizeWeight(1);
    }
});
setExtendedState(getExtendedState() | JFrame.MAXIMIZED_BOTH);