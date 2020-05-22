public class TestMain {
    public static void main(String[] args) throws Exception {
        new TestMain().run();
    }
    public void run() {
        // create and show a JFrame containing a chess board
        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Board board = new Board();
        board.getSquare(2, 4).setHighlighted(true);
        board.getSquare(3, 4).setHighlighted(true);
        window.getContentPane().add(board, BorderLayout.NORTH);
        window.pack();
        window.setVisible(true);
    }

    // *** Board represents the chess board
    private class Board extends JPanel {
        // *** the constructor creates the squares and adds a mouse click listener
        public Board() {
            setPreferredSize(new Dimension(squareSize * 8, squareSize * 8));
            // create the squares
            boolean rowStartRedFlag = true;
            for (int row = 0; row < 8; row++) {
                boolean redFlag = rowStartRedFlag;
                for (int column = 0; column < 8; column++) {
                    squares [row] [column] = new Square(this, row, column, redFlag);
                    redFlag = !redFlag;
                }
                rowStartRedFlag = !rowStartRedFlag;
            }
            // add mouse click listener
            this.addMouseListener(new MouseClickListener());
        }
        // *** mouse click listener
        private class MouseClickListener extends MouseAdapter {
            @Override
            public void mouseClicked(MouseEvent e) {
                Square square = getSquareAt(e.getX(), e.getY());
                String msg = square.isHighlighted() ? "Square is highlighted" : "Square is not highlighted";
                JOptionPane.showMessageDialog(null, msg);
            }
        }
        // ** override paint
        @Override
        public void paint(Graphics g) {
            draw ((Graphics2D) g);
        }
        // *** draw every square on the board
        public void draw(Graphics2D g) {
            for (int row = 0; row < squares.length; row++) {
                for (int column = 0; column < squares [row].length; column++) {
                    squares [row] [column].draw(g);
                }
            }
        }
        // *** get square given row and column
        public Square getSquare(int row, int column) {
            return squares [row] [column];
        }
        // *** get square from coords
        public Square getSquareAt(int x, int y) {
            int column = getColumnAtX(x);
            int row = getRowAtY(y);
            return squares [row] [column];
        }
        // *** get column # given x
        public int getColumnAtX(int x) {
            int column = x  / squareSize;
            return Math.min(Math.max(column, 0), 7);
       }
        // *** get row # given x
        public int getRowAtY(int y) {
            int row = y / squareSize;
            return Math.min(Math.max(row, 0), 7);
        }
        // ** get left x given column
        public int getLeftFromColumn(int column) {
            return column * squareSize;
        }
        // ** get top y give row
        public int getTopFromRow(int row) {
            return row * squareSize;
        }
        // *** get size of square side
        public int getSquareSize() {
            return squareSize;
        }
        private int squareSize = 25; // length of square side
        private Square [][] squares = new Square [8][8];
    }

    // *** Squalre represents one square on the board
    private class Square {
        // ** constructor creates the square
        public Square(Board board, int row, int column, boolean redFlag) {
            this.board = board;
            this.column = column;
            this.row = row;
            if (redFlag) {
                color = Color.RED;
                colorHighlighted = Color.PINK;
            } else {
                color = Color.BLACK;
                colorHighlighted = Color.LIGHT_GRAY;
            }
        }
        // ** set highlight flag
        public void setHighlighted(boolean value) {
            highlighted = value;
        }
        // *** see if square is highlighted
        public boolean isHighlighted() {
            return highlighted;
        }
        // *** draw the square
        public void draw(Graphics2D g) {
            Color fillColor = highlighted ? colorHighlighted : color;
            g.setColor(fillColor);
            int x = board.getLeftFromColumn(column);
            int y = board.getTopFromRow(row);
            int size = board.getSquareSize();
            g.fillRect(x, y, size, size);
        }
        private Board board;
        private Color color;
        private Color colorHighlighted;
        private int column;
        private boolean highlighted = false;
        private int row;
    }
}