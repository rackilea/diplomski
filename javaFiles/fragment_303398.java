public static void main(String[] args) {
    int array[][] = 
    {
        {6, 0, 0, 0, 0, 0},
        {5, 0, 0, 0, 0, 0},
        {4, 0, 0, 0, 0, 0},
        {3, 0, 0, 0, 0, 0},
        {2, 0, 0, 0, 0, 0},
        {1, 2, 3, 4, 5, 6}
    };

    int array2[][] =
    {
        {6},
        {5},
        {4},
        {3},
        {2},
        {1, 2, 3, 4, 5, 6}
    };

    print(array);
    System.out.println("\n");
    print(array2);
}

public static void print(int[][] array) {
    for (int i = 0; i < array.length; ++i) {
        if (i == array.length - 1) {
            System.out.print(array[i][0] + "\n ");
            for (int j = 0; j < array[i].length; ++j) {
                System.out.print(array[i][j] + " ");
            }
        } 
        else {
            System.out.println(array[i][0]);
        }
    }
}