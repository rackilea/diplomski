public static void quickSort(int[] a, int lo, int hi) {
    if (!(hi > lo)) {
        return;
    }
    int pivot = a[lo];
    int i = lo;
    int j = hi + 1;
    int temp;
    i++;
    j--;

    System.out.print("before: ");
    for (int k = lo; k <= hi; k++) {
        System.out.print(a[k] + ", ");
    }
    System.out.println();

    while (i <= j) {
        while (a[i] < pivot) {
            i++;
        }
        while (a[j] > pivot) {
            j--;
        }
        if (i <= j) {
            switchPlace(a, i, j);
            i++;
            j--;
        }
    }
    switchPlace(a, lo, j);

    System.out.print("after: ");
    for (int k = lo; k <= hi; k++) {
        System.out.print(a[k]);
        if (k == j) {
            System.out.print(" (pivot)");
        }
        System.out.print(", ");
    }
    System.out.println();
    System.out.println();

    quickSort(a, lo, j - 1);
    quickSort(a, j + 1, hi);
}

public static void switchPlace(int[] a, int x, int y) {
    int temp = a[x];
    a[x] = a[y];
    a[y] = temp;
}

public static void printList(int[] a) {
    String res = "";
    for (int i = 0; i < a.length; i++) {
        res += a[i] + " ";
    }
    System.out.println(res);
}

public static void main(String[] args) {
    //int[] a = {3, 7};
    //int[] a = { 9, 3, 10, 1, 8, 7 };
    int[] a = {24, 2 , 45 ,20 ,56 ,75 ,2 ,56 ,99 ,53 ,12};
    quickSort(a, 0, a.length - 1);
    printList(a);
}