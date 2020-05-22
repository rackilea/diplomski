EvenBeforeOdd(Array, n);
int lastEven = 0;
for (int i=0; i<Array.length; i++) {
    if (Array[i] % 2 == 0)
        lastEven = i;
}
int[] Array2 = new int[Array.length];
MergeSort(Array2, 0, lastEven);
MergeSort(Array2, lastEven+1, Array.length - 1);