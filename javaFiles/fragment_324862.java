static int partition(int arr[], int left, int right) {
    int pivot = arr[right];
    int i = left - 1;
    int tmp;
    for (int j = left; j <= right; j++) {
        if (arr[j] <= pivot) {
            i++;
            tmp = arr[i];
            arr[i] = arr[j];
            arr[j] = tmp;
        }
    }
    return i;
}

static void quicksort(int arr[], int left, int right) {
    if(left < right){
        int index = partition(arr, left, right);
        quicksort(arr, left, index - 1);
        quicksort(arr, index + 1, right);
    }
}