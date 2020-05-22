public class MainPanel extends JPanel {

    private CardLayout cl = new CardLayout();
    private JPanel panelHolder = new JPanel(cl);

    public MainPanel() {
        FirstPage firstPage = new FirstPage(this);
        SecondPage secondPage = new SecondPage(this);
        LeftBar leftBar = new LeftBar(this);