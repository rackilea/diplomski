import javax.swing.JOptionPane;

public class Determinant
{
  public static void main(String args[])
  {
    String sizeStr = JOptionPane.showInputDialog("What size?");
    int size = Integer.parseInt(sizeStr);
    int[][] matrix = new int[size][size];

    for(int i=0; i<size; i++) {
        for(int j=0; j<size; j++) {
            matrix[i][j] = (int) (Math.random() * 40) - 20;
        }
    }

    printArray(matrix);
    System.out.println("\nThe determinant = "+det(matrix));

  }


public static int det(int[][] A)
{
    int answer = 0;
    int place = 0;
    int[][] temp;
    int[][] temp1;
    if(A.length==1){
        return(A[0][0]);
    }
    for(int i = 0; i<A.length; i++){
        temp = new int[A.length-1][A[0].length-1];
        temp1 = Copy(temp, i);
        if(i%2==0){
            place = 1;
        }
        else{
            place = -1;
        }
        answer = answer + place * A[0][i] * det(temp1);
    }
    return answer;
  }



public static int[][] Copy(int[][] B, int i)
{
    //The C array size should be same as B
    int[][] C = new int[B.length][B[0].length];

    for(int j = 1; j<B.length; j++){
        for(int k = 0; k<B[0].length; k++){
            if(k>i){
                C[j-1][k-1]=B[j][k];
            }
            else{
                C[j-1][k]=B[j][k];
            }
        }
    }
    return C;
}


public static void printArray(int[][] A)
{
    for(int i=0; i<A.length; i++)
    {
        for(int j=0; j<A.length; j++)
        {
            int num = A[i][j];
            if(num<-9)
                System.out.print(" ");
            else if(num<0||num>9)
                System.out.print("  ");
            else
                System.out.print("   ");
            System.out.print(A[i][j]);
        }
        System.out.println();
    }
}