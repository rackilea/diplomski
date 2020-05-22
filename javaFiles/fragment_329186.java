public void overwritingMergeSort(int[] M) {
    int[] sorted = mergeSort(M);
    for(int i = 0; i < sorted.length; i++) {
        M[i] = sorted[i];
    }
}

int[] arr = new int[]{2,5,1,4,3};
System.out.println(Arrays.toString(arr));
overwritingMergeSort(arr);
System.out.println(Arrays.toString(arr));