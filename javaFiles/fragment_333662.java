public class TabbedPaneApp {

    private static void createAndShowGUI() {

        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JTabbedPane firstPanel = new JTabbedPane();
        JTabbedPane secondPanel = new JTabbedPane();

        JLabel firstLabel = new JLabel("First tabbed pane");
        JLabel secondLabel = new JLabel("Second tabbed pane");

        JTabbedPane tabbedPane = new JTabbedPane() {
            public Dimension getPreferredSize() {
                return new Dimension(500, 400);
            };
        };

        firstPanel.add(firstLabel);
        secondPanel.add(secondLabel);

        tabbedPane.add("First Panel", firstPanel);
        tabbedPane.add("Second Panel", secondPanel);
        frame.add(tabbedPane);

        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
}