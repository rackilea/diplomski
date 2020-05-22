int [] harry = new int [25];
for (int i = 0, n = 12; i < harry.length; i++) {
    if (i % 2 > 0) {
        harry[n] = i;
        n--;
    }
} 
for (int j = 0, m = harry.length - 1; j < harry.length; j++) {
    if (j % 2 == 0) {
        harry[m] = j;
        m--;
    }
}