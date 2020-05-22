int j = 0;
int k = 0;
for (int i = 0; i < values.length && i < noOfNumbers; i++) {
    if (values[i] >= 500) {
        values3[k] = values[i];
        k++;
    } else {
        values2[j] = values[i];
        j++;
    }
}