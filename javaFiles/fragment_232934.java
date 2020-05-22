public class PipeGameApp extends JFrame implements ActionListener {

    private static int BOARD_SIZE = 11;
    private PipeGame game;      // The model
    private PipeGameView view;      // The view
    private JButton startButton; // *** note change ***

    public PipeGameApp(String title) {

        startButton = new JButton("Start"); // *** note change ***
        startButton.addActionListener(this);
        // etc...