public class SeaGlassExercise {

    public static void initWindow() {
        JFrame frame = new JFrame("Application Name");
        CustomTabbedPane content = new CustomTabbedPane();
        frame.setContentPane(content);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLocationByPlatform(true);
//        try {
//            UIManager.setLookAndFeel(
//        "com.seaglasslookandfeel.SeaGlassLookAndFeel");
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        SwingUtilities.updateComponentTreeUI(frame);
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                initWindow();
            }
        });
    }

}

class CustomTabbedPane extends JPanel {

    public CustomTabbedPane() {
        super(new GridLayout(1, 1));
        JTabbedPane tabbedPane = new JTabbedPane();
        JComponent panel1 = makeTextPanel("Panel #1");
        tabbedPane.addTab("AAA", panel1);
        JComponent panel2 = makeTextPanel("Panel #2");
        tabbedPane.addTab("BBB", panel2);
        JComponent panel3 = makeTextPanel("Panel #3");
        tabbedPane.addTab("CCC", panel3);
        JComponent panel4 = makeTextPanel("Panel #4");
        tabbedPane.addTab("DDD", panel4);
        add(tabbedPane);
        tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
    }

    protected JComponent makeTextPanel(String text) {
        JPanel panel = new JPanel();
        JLabel filler = new JLabel(text);
        filler.setHorizontalAlignment(JLabel.CENTER);
        panel.setLayout(new GridLayout(1, 1));
        panel.add(filler);
        return panel;
    }
}