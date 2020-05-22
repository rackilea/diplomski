public class EightQueensGame {
    public static void main(String[] args) throws FileNotFoundException {
        EightQueensUI eightQueens = new EightQueensUI(8);

        eightQueens.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        eightQueens.pack();

        eightQueens.setVisible(true);//just for testing
        eightQueens.solver.printBoard();
    }
}