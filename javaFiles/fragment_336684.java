int i, j;
float sum = 0;
for (i = 0; i < a.length; i++) {
    for (j = 0; j < a[i].length && j < b.length; j++) {
        sum += a[i][j] * b[j];
    }
}
System.out.println(sum);