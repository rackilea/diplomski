int rowSum = 0;
int current = 0;
int[] a = new int[values.length];                   // proper initialization to avoid NPE
for (int i=0; i<values.length; i++) {
                                                    // this line removed
    for (int j=0; j<values[current].length; j++) {
        rowSum = values[current][j];
        a[i] += rowSum;
    }
    rowSum = 0;
    current++;
}
return a;