public class Demo extends JFrame {

/////////////////////////////////////////////////////////////////////////
// JMenuBar
private final JMenuBar mainMenuBar;
    private final JMenu fileMenu;
        private final JMenuItem exitFileMenu;
/////////////////////////////////////////////////////////////////////////
// CONTENT PANE & COMPONENTS
private final JPanel contentPanel;
    private final JPanel buttonPanel;
        private final JButton button1;

/////////////////////////////////////////////////////////////////////////
// GLASSPANE AND COMPONENTS
private final JPanel glassPanel;
    private final JPanel buttonPanel2;
    private final JButton button2;

public Demo() {
    super();

    this.mainMenuBar = new JMenuBar();
        this.fileMenu = new JMenu("File");
            this.exitFileMenu = new JMenuItem("EXIT");

    this.contentPanel = new JPanel(new BorderLayout());
        this.buttonPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
            this.button1 = new JButton("Button 1");

    this.glassPanel = new JPanel(new BorderLayout());
        this.buttonPanel2 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
            this.button2 = new JButton("Button 2");
}

public void initGUI() {
        this.fileMenu.add(this.exitFileMenu);
    this.mainMenuBar.add(this.fileMenu);

        this.buttonPanel.add(this.button1);
    this.contentPanel.add(this.buttonPanel, BorderLayout.NORTH);


        this.buttonPanel2.add(this.button2);
        this.buttonPanel2.setOpaque(false);
    this.glassPanel.add(this.buttonPanel2, BorderLayout.NORTH);

    super.setContentPane(this.contentPanel);
    super.setGlassPane(this.glassPanel);

    this.glassPanel.setOpaque(false);
    this.glassPanel.setVisible(true);

    super.setExtendedState(JFrame.MAXIMIZED_BOTH);
    super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    super.setJMenuBar(mainMenuBar);
    super.setVisible(true);
}

public static void main(String[] args) {
    Demo obj = new Demo();
    obj.initGUI();
}