public class Display {

    public static final String START_VIEW = "start";
    public static final String MAIN_VIEW = "main";

    JFrame frame;

    StartMenu start = new StartMenu();
    MainMenu main = new MainMenu();

    JPanel panel = new JPanel();

    JPanel startPanel = start.createPanel();
    JPanel mainPanel = main.createPanel();

    CardLayout card = new CardLayout();

    public void createDisplay() {
        frame = new JFrame("Insert Name");
        frame.setPreferredSize(new Dimension(800, 600));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(panel, BorderLayout.CENTER);

        panel.setLayout(card);
        panel.add(startPanel, START_VIEW);
        panel.add(mainPanel, MAIN_VIEW);

        mainPanel.setVisible(false);
        startPanel.setVisible(true);

        frame.add(panel);
        frame.pack();
        frame.setVisible(true);
        frame.setResizable(false);
    }

    public void switchPanel(String x) {
        card.show(panel, x);
    }
}