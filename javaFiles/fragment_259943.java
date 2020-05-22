public class Example {

    static String[][] board;

    static void display() {

        for (String[] row : board) {
            for (String card : row) {
                System.out.print(card + "\t");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {

        board = new String[][] {
            { " 1C", " 2C", " 3C", " 4C", " 5C", " 6C", " 7C" },
            { "   ", " 1H", "10H", " AC", " 5C", " 6C", "10D" },
            { "   ", "   ", "10H", " AC", " 5C", " 6C", "10D" },
            { "   ", "   ", "   ", " AC", " 5C", " 6C", " QS" },
            { "   ", "   ", "   ", "   ", " 5C", " 6C", " KS" },
            { "   ", "   ", "   ", "   ", "   ", " 6C", " AS" },
            { "   ", "   ", "   ", "   ", "   ", "   ", "10D" }};

        display();
    }
}