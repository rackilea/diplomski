class testMatrixSO{
    public static void main(String[] args){

        int[][] students_exams = 
        {
        {3, 1, 2, 5, 8},   // student 1
        {10, 4, 5, 7},     // student 2
        {1, 2, 3, 6},      // student 3
        {2, 7, 4, 5},      // student 4
        {1, 6, 2, 10},     // student 5
        {8, 9, 1, 3}       // student 6
        };

        int[][] finalMatrix = new int[10][10];
        //here is the part that creates your matrix
        for(int i=0; i<students_exams.length; i++)
            for(int j=0; j<students_exams[i].length; j++)
                for(int k=0; k<students_exams[i].length; k++)
                    if(j != k) finalMatrix[students_exams[i][j]-1][students_exams[i][k]-1]++;



        //print results
        for(int i=0; i < finalMatrix.length; i++){
            for(int j=0; j < finalMatrix[i].length; j++)
                System.out.print(finalMatrix[i][j] + " ");
            System.out.println();
        }

    }
}