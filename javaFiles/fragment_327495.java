import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;

public class CleanIt {

    /**
     * @param args
     * @throws UnsupportedEncodingException 
     */
    public static void main(String[] args) throws UnsupportedEncodingException {
//      double[][] matrix = readFromConsole(System.in);
        String input = "3\n3\n1 0 2\n0 0 0\n3 0 4\n";
        double[][] matrix = read(new ByteArrayInputStream(input.getBytes("UTF-8")));

        write(matrix,System.out);
        double[][] rowsCleaned = cleanZeroRows(matrix);
        write(rowsCleaned,System.out);
        double[][] transposed = transpose(rowsCleaned);
        write(transposed,System.out);
        double[][] colsCleaned = cleanZeroRows(transposed);
        write(colsCleaned,System.out);
        double[][] transposedBack = transpose(colsCleaned);
        write(transposedBack,System.out);
    }

    private static double[][] cleanZeroRows(double[][] matrix) {
        //first find those that need to delete
        boolean[] deleteThese = new boolean[matrix.length];
        int count = 0;

        int rows = matrix.length;
        int cols = matrix[0].length;
        for(int i=0;i<rows;i++){
            boolean allZeros = true;
            for(int j=0;j<cols;j++){
                if (matrix[i][j] != 0){
                    allZeros = false;
                    break;
                }
            }           
            deleteThese[i] = allZeros;
            if (allZeros){
                count++;
            }
        }

        //
        if (count == 0){
            return matrix;
        }else if (count == matrix.length){
            return new double[0][0];
        }else{
            double[][] newMatrix = new double[rows - count][cols];
            int idx = -1;
            for(int i=0;i<rows;i++){
                if (!deleteThese[i]){
                    idx++;
                    newMatrix[idx] = matrix[i];
                }
            }
            return newMatrix;
        }
    }

    /**
     * expects N\nM\ne1 e2 e3 e4 e5 e6 e7...
     * @param in 
     * @return
     */
    private static double[][] read(InputStream in) {
        Scanner scan = new Scanner(in);
        int rows = scan.nextInt();
        int cols = scan.nextInt();
        double[][] matrix = new double[rows][cols];
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                matrix[i][j] = scan.nextDouble();
            }           
        }
        return matrix;
    }

    private static void write(double[][] matrix, PrintStream out) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                out.print(matrix[i][j]);
                out.print(" ");
            }           
            out.print("\n");
        }
        out.print("\n");
    }

    public static double[][] transpose(double[][] m) {
        int r = m.length;
        int c = m[0].length;
        double[][] t = new double[c][r];
        for (int i = 0; i < r; ++i) {
            for (int j = 0; j < c; ++j) {
                t[j][i] = m[i][j];
            }
        }
        return t;
    }

}