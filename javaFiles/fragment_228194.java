import java.util.*;

public class Assignment2 {
    Scanner keyboard = new Scanner(System.in);
    private char[][] wordBoard;
    private char[][] gameBoard;
    private String[] wordList;
    private static int row;
    private static int col;
    Random rnd = new Random();

    public void playWordSearch() {
        wordBoard = numRowCol();
        wordStorage(wordBoard);
    }

    public static void main(String[] args) {
        Grid grid = new Grid();
        grid.playWordSearch();


    }

    /**
     * This method asks the user to input an integer for Rows/Columns
     * And gracefully handles invalid input :)
     *
     * @return
     */
    public char[][] numRowCol() {

        int array[] = new int[100];
        boolean again = true;

        while (again) {
            for (int i = 0; i <= 1; i++) {
                try {
                    if (i == 0) {
                        System.out.printf("Enter a number of rows (2-15): %n");
                        array[i] = keyboard.nextInt();
                        if (array[i] > 15 || array[i] < 2) {
                            System.out.printf("Requirements: int between [2-15] %n");
                            i -= 1;
                        }
                    }
                } catch (InputMismatchException e) {
                    System.out.printf("Requirements: int between [2-15] %n");
                    i -= 1;
                    keyboard.next();
                    e.printStackTrace();
                }
                try {
                    if (i == 1) {
                        System.out.printf("Enter a number of columns (2-15): %n");
                        array[i] = keyboard.nextInt();
                        if (array[i] > 15 || array[i] < 2) {
                            System.out.printf("Requirements: int between [2-15] %n");
                            i -= 1;
                        }
                    }
                } catch (InputMismatchException e) {
                    System.out.printf("Requirements: int between [2-15] %n");
                    i -= 1;
                    keyboard.next();
                    e.printStackTrace();
                }
            }
            again = false;
        }
        System.out.printf("The amount of rows you have entered: %d%nAnd the amount of columns: %d%n", array[0], array[1]);
        char[][] arrayArray = new char[array[0]][array[1]];
        return arrayArray;
    }

    public int wordStorage(char[][] arrayArray) {
        int size;
        String word[] = new String[arrayArray.length];
        int sizeRow = arrayArray.length;
        int sizeCol = arrayArray[1].length;

        System.out.printf("rows: %d%n", sizeRow);
        System.out.printf("cols: %d%n", sizeCol);
        for (int i = 0; i < arrayArray.length; i++) {
            System.out.printf("Enter a word with less than %d characters: %n", sizeCol);
            word[i] = keyboard.next();
        }
        keyboard.close();
        for (int i = 0; i < word.length; ++i) {
            arrayArray[i] = word[i].toCharArray();
        }
        System.out.println(Arrays.deepToString(arrayArray).replace("], ",
            "]\n").replace("[[", "[").replace("]]", "]"));
        return 100;
    }
}