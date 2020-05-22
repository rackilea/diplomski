import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;

public class SudokuProject {
    public static void main(String[] args) {
        int[][] sudokuNumbers = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        try (
                PrintStream output = new PrintStream(new File("output.txt"));) {
            for (int i = 0; i < sudokuNumbers.length; i++) {
                String s= "";
                for (int j = 0; j < sudokuNumbers[i].length; j++) {
                    s+= "|" + sudokuNumbers[i][j] + "|";
                }
                output.println(s);
            }
            output.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
}