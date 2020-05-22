public static void main(String[] args) {

        int rows=5;
        int cols=5;
        double[][] matrix = new double[rows][cols];

        int counter =0;

        for(int i=0; i<rows; i++)
        for(int j=0; j<cols; j++){

            matrix[i][j] = Math.random();
             // counter++;
           // System.out.println("First test ("+counter+") : " + matrix[i][j]);

        }

        //keep copy of original matrix
        double[][] matrixCopy = matrix.clone();

        //Assume 
        int rowToRemove = 2;
        int colToRemove = 3;


        // re-initialise matrix with dimension i-1 , j-1
        matrix = new double[rows-1][cols-1];
        counter = 0;

        //row and column counter for the new matrix
        int tmpX=-1;
        int tmpY=-1;


        //re-populate new matrix by searching through the original copy of matrix, while skipping useless row and column
        // works only for 1 row and 1 column in a 2d array but by changing the conditional statement we can make it work for n number of rows or columns in a 2d array.
        for(int i=0; i<rows; i++)
        {
         tmpX++;
         if(i==rowToRemove){
             tmpX--;
         }
         tmpY=-1;
            for(int j=0; j<cols; j++){


               tmpY++;
              if(j==colToRemove){
              tmpY--;
              }

                 if(i!=colToRemove&&j!=colToRemove){
                       counter++;
                   matrix[tmpX][tmpY] = matrixCopy[i][j];

                   System.out.println(counter+" :"+matrix[tmpX][tmpY]);
                 }


            }

        }