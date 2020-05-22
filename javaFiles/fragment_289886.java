public void print(final char appearance, final int size){
    for (int i = 1; i <= size; i++) {
        for (int j = size - i; j >0; j--)
            System.out.print(" ");
        for (int k = i; k > 0; k--)
            System.out.print(appearance);
        System.out.println();
    }
}