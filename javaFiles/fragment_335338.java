public class Main {

  public static void makeMatrix(int n){

    int[][] matrix = new int[n][n];
    int i,j;

    int x=0, y=0, flipX=0, flipY=0;

    for (int k=0;k<n*n;k++){

      if (x >= n){
        y = ++flipX;
        x = 0;
      }
      else if (y >= n){
        x = ++flipY;
        y = 0;
      }

      matrix[x++][y++] = k+1;
    }

    //To print it
    int sizeOfMaxDigit = String.valueOf(n * n).length();
    for (i=0; i<n; i++) {
      for(j=0; j<n; j++) {
        System.out.printf("%" + sizeOfMaxDigit + "d ", matrix[i][j]);
      }
      System.out.println();
    }

  }

  public static void main(String[] args){

    makeMatrix(1);
    System.out.println();
    makeMatrix(2);
    System.out.println();
    makeMatrix(3);
    System.out.println();
    makeMatrix(4);
    System.out.println();
    makeMatrix(5);
    System.out.println();
    makeMatrix(6);
    System.out.println();
    makeMatrix(10);

  }

}