public class MyClass {
    public static void main(String args[]) {

        int dimension = 5;

        int[][] numberSeq = new int[dimension][dimension];

        numberSeq[0][0] = 1; numberSeq[0][1] = 2;numberSeq[0][2] = 3;numberSeq[0][3] = 4;numberSeq[0][4] = 5;
        numberSeq[1][0] = 6; numberSeq[1][1] = 7;numberSeq[1][2] = 8;numberSeq[1][3] = 9;numberSeq[1][4] = 10;
        numberSeq[2][0] = 11;numberSeq[2][1] = 12;numberSeq[2][2] = 13;numberSeq[2][3] = 14;numberSeq[2][4] = 15;
        numberSeq[3][0] = 16;numberSeq[3][1] = 17;numberSeq[3][2] = 18;numberSeq[3][3] = 19;numberSeq[3][4] = 20;
        numberSeq[4][0] = 21;numberSeq[4][1] = 22;numberSeq[4][2] = 23;numberSeq[4][3] = 24;numberSeq[4][4] = 25;

        int[][] flippedSeq = new int[dimension][dimension];

        // This is the flipping part
        for(int i = 0; i < dimension; i++)
        {
            for(int j = 0; j < dimension; j++)
            {
                flippedSeq[i][j] = numberSeq[dimension-1-j][dimension-1-i];
            }
        }

        PrintMatrix(numberSeq);
        System.out.println();
        PrintMatrix(flippedSeq);


    }

    public static void PrintMatrix(int[][] mat)
    {
        for(int i = 0; i < mat.length; i++)
        {
            for(int j = 0; j < mat[i].length; j++)
                System.out.print(mat[i][j] + " ");
            System.out.println();
        }
    }
}