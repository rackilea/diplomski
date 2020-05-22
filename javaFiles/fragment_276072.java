...
for (i = 1; i < numbrid.length; i++) {
    k = numbrid[i];
    j = i - 1;
    while ((j > -1) && (numbrid[j] > k)) {
        numbrid[j + 1] = numbrid[j];
        j--;
    }
    numbrid[j + 1] = k;
}
...