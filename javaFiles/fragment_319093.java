public class GameFrame {

   private GameBoard gameBoard;

    /**
     * Creates a new frame.
     *
     * @param gameTitle the title of the frame
     */
    public GameFrame(String gameTitle) {
        JFrame frame = new JFrame(gameTitle);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        gameBoard = new GameBoard();
        frame.add(gameBoard);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}