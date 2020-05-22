int size = listResult.size();
int[] result = new int[size];
Integer[] temp = listResult.toArray(new Integer[size]);
for (int n = 0; n < size; ++n) {
    result[n] = temp[n];
}