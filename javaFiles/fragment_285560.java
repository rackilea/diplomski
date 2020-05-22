for (int i = Array1.length - 1; i >= 0; i-- ) {
    if ((i != Array1.length-1) && ((Array1.length - i - 1)%8 == 0)) {
        System.out.println();
    }
    System.out.print(Array1[i] + " ");
}