public class GameBoard extends JPanel {

    private GameTile[][] gameBoard = new GameTile[8][8];

    public GameBoard() {
        initiateLayout();
    }

    private void initiateLayout() {
        setLayout(new GridLayout(8, 8));

        BufferedImage image = null;
        try {
            image = ImageIO.read(new URL("http://i.imgur.com/ejmCtui.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                gameBoard[row][col] = new GameTile(image, col, row);
                add(gameBoard[row][col]);
            }
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                gameBoard[row][col].repaint();
            }
        }
    }
}