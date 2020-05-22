public Base() {
    MainPanel mainPanel = new MainPanel();
    LeftBar leftBar = new LeftBar(mainPanel);
    frame.setLayout(bl);
    frame.setSize(800, 600);
    frame.add(leftBar, BorderLayout.WEST);
    frame.add(mainPanel, BorderLayout.CENTER);