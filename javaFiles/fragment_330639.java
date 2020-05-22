class Examprep1 {
    public static void main(String[] args) {
        int[][] array = new int[2][4];
        array[0][0] = 1;
        array[0][1] = 5;
        array[0][2] = -7;
        array[0][3] = 9;
        array[1][0] = -2;
        array[1][1] = 4;
        array[1][2] = 6;
        array[1][3] = -8;

        int x = 0;

        // Using for loops to create the 2D array
        System.out.println("Printing old array");
        printArray(array);

        System.out.println("Printing new  array");
        printArray(newArray(array, x));

    }

    private static void printArray(int[][] a) {
        for (int rows = 0; rows < 2; rows++) {
            for (int cols = 0; cols < 4; cols++) {

                System.out.print(a[rows][cols] + " ");
            }
            System.out.println("");
        }

    }

    private static int[][] newArray(int[][] old, int x) {
        int y;
        int[][] current = new int[2][4];

        for (int rows = 0; rows < 2; rows++) {
            for (int cols = 0; cols < 4; cols++) {

                y = Math.abs(old[rows][cols]);
                current[rows][cols] = y;

            }

        }
        return current;
    }

}