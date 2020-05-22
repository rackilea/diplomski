public class HollowSquare {

    private static final char squareChar = '*';
    private static final char holeChar = ' ';

    public static void main(String[] args) {
        try (Scanner ma = new Scanner(System.in)) {
            System.out.print("Enter the number:");
            int max = ma.nextInt();
            repeatChar(squareChar, max);
            System.out.println();
            repeatMiddleLine(max - 2, max);
            repeatChar(squareChar, max);
            System.out.println();
        }
    }

    private static void repeatMiddleLine(int lineCount, int lineLength) {
        if (lineCount > 0) {
            System.out.print(squareChar);
            repeatChar(holeChar, lineLength - 2);
            System.out.println(squareChar);
            repeatMiddleLine(lineCount- 1, lineLength);
        }
    }

    private static void repeatChar(char c, int count) {
        if (count > 0) {
            System.out.print(c);
            repeatChar(c, count - 1);
        }
    }

}