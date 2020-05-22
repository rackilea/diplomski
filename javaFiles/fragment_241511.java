int[] result = new int[array.length];
int k = 0;
for (int v : array) {
    if (v != 0) {
        result[k++] = v;
    }
}