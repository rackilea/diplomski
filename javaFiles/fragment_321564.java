Comparable[][] arrays = new Comparable[100][];
for (int i=1; i<101;i++){
    arrays[i] = new Comparable[/* relevant length here*/]; // <====
    for (int j=0; j <= i-1; j++){
        arrays[i][j] = generator.nextInt(max);
    }
}