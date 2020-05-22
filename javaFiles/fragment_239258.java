private static void createAndShowGui() {

    JFrame frame = new JFrame("This should be working now...");
    MainPanel mainPanel = new MainPanel();
    frame.setLayout(new BorderLayout());

    // pointless considering the setContentPane call
    //frame.add(mainPanel, BorderLayout.CENTER);
    frame.setContentPane(mainPanel);
    frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    frame.pack();
    frame.setLocationByPlatform(false);
    //frame.setSize(500, 500);
    frame.setVisible(true);
}