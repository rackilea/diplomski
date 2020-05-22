public static void print(int[] array, int blockSize) {

    for (int i = 0; i < array.length; i++) {
        System.out.print(" " + array[i]);
        if((i + 1) % blockSize == 0)
        {
            System.out.println();
        }
    }
    System.out.println();
}