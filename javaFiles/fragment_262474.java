int[] newArray = new int[3 * a.length];
int index = 0;
for (int n = 0; n < a.length; n++) {
    newArray[index++] = a[n];
    newArray[index++] = b[n];
    newArray[index++] = c[n];
}