import java.util.Scanner;

public class DiagonalsSum {

public static void main(String[] args) {
Scanner s = new Scanner(System.in);
int[][] matrix;
int[] sizes = new int[2];
int diagonalsSum = 0, i, j, n, m;
for(i = 0; i < 2; i++){
    n = i + 1;
    System.out.println("Inform the " + n + " dimension of the matrix");
    sizes[i] = s.nextInt();
}
matrix = new int[sizes[0]][sizes[1]];

for(i = 0; i < sizes[0]; i++){
    n = i + 1;
    System.out.println(n);
    for(j = 0; j < sizes[1]; j++){
        m = j = 1;
        System.out.println("Inform the value of " + n + "." + m +
                " in the matrix:");
        matrix[i][j] = s.nextInt();
    }
}
s.close();
i = 0;
j = 0;
while(i < sizes[0] && j sizes[1]){
    diagonalsSum += matrix[i][j];
    i++;
    j++;
}
i = 0;
j = (sizes[1] - 1);
while(i < sizes[0] && j > -1){
    diagonalsSum += matrix[i][j];
    i++;
    j--;
}
System.out.println("The sum of the primary and secondary diagonals is " + diagonalsSum);