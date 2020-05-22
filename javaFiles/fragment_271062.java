public class SodokuBoardDemo {

    public static void main(String... args) {
        SudokuBoard board = new SudokuBoard();    
        JFrame frame = new JFrame("Sodoku");
        frame.add(board);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);            
        frame.setVisible(true);
    }

    public static class SudokuBoard extends JPanel {

        public SudokuBoard() {
            setBorder(BorderFactory.createLineBorder(Color.GRAY));
            setLayout(new GridLayout(3, 3));
            BoardPart input[] = new BoardPart[9];
            for (int i = 0; i < 9; i++) {
                input[i] = new BoardPart();
                add(input[i]);
            }
        }

        public static class BoardPart extends JPanel {

            public BoardPart() {
                setBorder(BorderFactory.createLineBorder(Color.GRAY));
                setLayout(new GridLayout(3, 3));
                JTextField input[] = new JTextField[9];
                for (int i = 0; i < 9; i++) {
                    input[i] = new JTextField();
                    input[i].setPreferredSize(new Dimension(30, 30));
                    add(input[i]);
                }
            }
        }
    }
}