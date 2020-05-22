public class SplitPaneDemo extends JFrame {
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> new SplitPaneDemo());
    }

    SplitPaneDemo() {
        super("SplitPaneDemo");

        JLabel lhs = new JLabel("LHS");
        lhs.setPreferredSize(new Dimension(320, 200));

        JLabel rhs = new JLabel("RHS");
        rhs.setPreferredSize(new Dimension(320, 200));

        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
        splitPane.setContinuousLayout(true); // Update window as splitter is moved
        splitPane.setLeftComponent(lhs);
        splitPane.setRightComponent(rhs);

        setContentPane(splitPane);
        pack();
        setVisible(true);
    }
}