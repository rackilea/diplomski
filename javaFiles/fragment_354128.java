public static void main(String args[]) {
        int[] array = { 1, 3, 17, 5, 6, 7, 11, 19, 4, 2, 15, 8, 13, 15, 9, 14, 12, 16, 18, 10 };
        System.out.println(Arrays.toString(array));
        quicksort(array, 0, array.length - 1);
        System.out.println(Arrays.toString(array));
    }

    public static void quicksort(int[] array, int startIndex, int endIndex) {
        System.out.println("quicksort(" + Arrays.toString(array) + ", " + startIndex + ", "
                + endIndex + ")");
        if (startIndex < endIndex) {
            int p = partition(array, startIndex, endIndex);
            quicksort(array, startIndex, p - 1);
            quicksort(array, p + 1, endIndex);
        }
    }

    public static int partition(int[] array, int startIndex, int endIndex) {
        System.out.println("partition(" + Arrays.toString(array) + ", " + startIndex + ", "
                + endIndex + ")");
        int startValue = array[startIndex];
        int h = startIndex;
        for (int k = startIndex + 1; k <= endIndex; k++) {
            if (array[k] < startValue) {
                h++;
                swap(array, h, k);
            }
        }
        swap(array, startIndex, h);
        return h;
    }

    public static void swap(int a[], int indexa, int indexb) {
        System.out.println("Before Swap: " + Arrays.toString(a));
        System.out.println(a[indexa] + " <-> " + a[indexb]);
        int aux = a[indexa];
        a[indexa] = a[indexb];
        a[indexb] = aux;
        System.out.println("After Swap: " + Arrays.toString(a));
    }