public class TestBoard {

    public static void main(String[] args) {
        new TestBoard();
    }

    public TestBoard() {

        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {

                new GameBoard();

            }
        });

    }

    public class GameBoard extends JFrame {

        public GameBoard() {

            JFrame frame = new JFrame();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setLayout(new GridBagLayout());
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.gridx = 0;
            gbc.gridy = 0;

            Rectangle1 board[][] = new Rectangle1[3][3];
            for (int row = 0; row < board.length; row++) {

                gbc.gridx = 0;

                for (int col = 0; col < board[row].length; col++) {
                    board[row][col] = new Rectangle1(195, 215);
                    if ((row + col) % 2 == 0) {
                        board[row][col].setBackground(Color.YELLOW);
                    } else {
                        board[row][col].setBackground(Color.RED);
                    }
                    frame.add(board[row][col], gbc);
                    gbc.gridx++;
                }

                gbc.gridy++;

            }

            frame.pack();
            frame.setVisible(true);

        }
    }

    public class Rectangle1 extends JPanel {

        public Rectangle1(int w, int h) {
            setPreferredSize(new Dimension(w, h));
        }

    }
}