import java.util.Scanner;

class Matrix{

    public static void main(String[] args){

        char[][] matrix = new char[5][5];  
        Scanner in = new Scanner(System.in);

        System.out.println("\nInput 5x5 char matrix one line at a time:\n");

        for(int i = 0; i < matrix.length; i++){
                String row = in.nextLine();
                for(int j=0;j<matrix[i].length;j++){
                    matrix[i][j]=row.charAt(j);
                }
        }

        System.out.println("\nOutput:\n");
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[i].length; j++){
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
    }
}