public class MainPanel extends JPanel {
    private DrawPanel[][] panels;
    public MainPanel(int rows, int cols) {
        setLayout(new GridLayout(rows, cols));
        panels = new DrawPanel[rows][cols];
    }
}