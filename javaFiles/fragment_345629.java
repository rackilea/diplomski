for (int row = 1; row <= size; row++) {
    for (int col = 1; col <= row; col++) {
        System.out.print((size - row + 1) + "\t");
    }

    System.out.println();
}