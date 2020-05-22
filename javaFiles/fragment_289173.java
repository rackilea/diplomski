private void initComponents(Container contentPane) {
    mainPanel = new JPanel();
    leftPanel = new JPanel();
    rightPanel = new JPanel();
    leftPanel.add(new JLabel("left"));
    rightPanel.add(new JLabel("right"));
    leftPanel.setPreferredSize(new Dimension(200, 40));
    rightPanel.setPreferredSize(new Dimension(280, 400));
    leftPanel.setBackground(Color.WHITE);
    rightPanel.setBackground(Color.WHITE);

    JSplitPane mainJsp = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
    mainJsp.add(leftPanel, JSplitPane.TOP);
    mainJsp.add(rightPanel, JSplitPane.BOTTOM);
    mainJsp.setOneTouchExpandable(true);
    mainJsp.setDividerLocation(150);
    mainPanel.add(mainJsp);
    contentPane.add(mainPanel);

    leftPanel = new PaintPanel();
    // Just left hanging here, never added to anything...?

}