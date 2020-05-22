public static void main(String[] args) {
    int matrix[][] = new int[][] { { 1, 2, 3 }, { 1, 0, 2 }, { 0, 1, 2 } };
    int array[] = { 0, 1, 2, 3, 4, 5, 6, 7, 8 };

    int globalCount = 0;
    int count = 0;
    int a = 0;
    int row = 0, col = 0;
    boolean done = false;

    for (count = 0; count < array.length; count += 3) {
        for (row = 0; row < 3; row++) {
            for (col = 0; col < 3; col++) {
                a = matrix[row][col] * array[count++];
                System.out.println("Result" + globalCount++ + " " + a);

            }
            count -= 3;

        }

    }
}