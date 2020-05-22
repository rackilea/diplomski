/**
 * @param args the command line arguments
 */
public static void main(String[] args) {
    GlassView view = new GlassView();
}

private static class GlassView extends JFrame {

    private int width = 600;
    private int height = 750;

    public GlassView() {
        this.setSize(width, height);
        this.setVisible(true);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JPanel glass = new JPanel();
        glass.setSize(450, 750);
        glass.setBackground(Color.BLUE);
        glass.setVisible(true);

        JPanel controls = new JPanel();
        controls.setSize(150, 750);
        controls.setBackground(Color.RED);
        controls.setVisible(true);

        JSplitPane splitPane = new JSplitPane();
        splitPane.setSize(width, height);
        splitPane.setDividerSize(0);
        splitPane.setDividerLocation(150);
        splitPane.setOrientation(JSplitPane.HORIZONTAL_SPLIT);
        splitPane.setLeftComponent(controls);
        splitPane.setRightComponent(glass);

        this.add(splitPane);
    }
}