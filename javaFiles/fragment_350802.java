private static boolean isHighestInItsRow(int[][] array, int row, int col) {
    // I'll leave that to you
}

private static boolean isLowestInItsColumn(int[][] array, int row, int col) {
    // I'll leave that to you
}

public static void main(String[] args) {
    int [][] array = {
        { 1 , 3 , 32},
        { 4 , 5 , 6 },
        { 7 , 8 , 9 }
    };

    for (int r=0; r<array.length; r++) {
        for (int c=0; c<array[r].length; c++) {
            if (isHighestInItsRow(array, r, c) && isLowestInItsColumn(array, r, c)) {
                System.out.println("Solution is row " + r + " / column " + c);
            }
        }
    }
}