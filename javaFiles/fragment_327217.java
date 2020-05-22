import java.util.Random;

public class Main {

    public static void main(String[] args) {
        Random rand = new Random();

        String[][] matrix  = new String[7][7];
        for (int row = 0; row < matrix.length; row++) {
            for (int column = 0; column < matrix[row].length; column++) {
                matrix[row][column] = String.valueOf(rand.nextInt(5));
            }
        }

        for (int row = 0; row < matrix.length; row++) {
            for (int column = 0; column < matrix[row].length; column++) {
                System.out.print(matrix[row][column] + " ");
            }
            System.out.println();
        }
    }
}