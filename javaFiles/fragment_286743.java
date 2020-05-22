public class MainPanel extends JPanel {
    private CardLayout cl = new CardLayout();
    private JPanel panelHolder = new JPanel(cl);

    public MainPanel() {
        NewSession session = new NewSession();  // *****