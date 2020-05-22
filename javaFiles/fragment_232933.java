public class PipeGameApp extends JFrame implements ActionListener {

    private static int BOARD_SIZE = 11;
    private PipeGame game;      // The model
    private PipeGameView view;      // The view

    public PipeGameApp(String title) {

        JButton startButton = new JButton("Start");
        startButton.addActionListener(this);
        // etc...