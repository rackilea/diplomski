public static void main(String[] args) throws Exception {

    JTabbedPane tabs = new JTabbedPane(JTabbedPane.LEFT);
    tabs.setUI(new BasicTabbedPaneUI() {
        @Override
        protected int calculateTabWidth(
                int tabPlacement, int tabIndex, FontMetrics metrics) {
            return 200; // the width of the tab
        }
    });

    tabs.add("Tab 1", new JButton());
    tabs.add("Tab 2", new JButton());

    JFrame frame = new JFrame("Test");
    frame.add(tabs);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(400, 300);
    frame.setVisible(true);
}