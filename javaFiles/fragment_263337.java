public static void printArray(int[][] a) {
    System.out.println("\t");

    for (int col=0; col < a[0].length; col++) {
        System.out.print(" " + col + " \t");  // use spaces instead of brackets
    }

    System.out.println();

    for (int row=0; row < a.length; row++) {
        System.out.print(" " + row + " \t");  // use spaces not brackets

        for (int col=0; col < a[row].length; col++) {
            System.out.print(a[row][col] + "\t");
        }

        System.out.println();
    }
}