int[] x = new int[] {a, b, c, d, e, f, g, h, i};
for (int i = 0 ; i != x.length ; i++ ) {
    for (int j = i+1 ; j != x.length ; j++ ) {
        ... // Use x[i] and x[j] here
    }
}