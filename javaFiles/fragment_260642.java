for (int r=0; r<10; r++) {
    for (int c=0; c<=r; c++) {
        int value = calculateDigit(r, c);
        System.out.print(value+" ");
    }
    System.out.println();
}