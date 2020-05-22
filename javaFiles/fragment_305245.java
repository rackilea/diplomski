public static void reverse(int[] a) {
    for (int i = 0 ; i < a.length / 2 ; i++) {
        int t = a[i];
        a[i] = a[a.length - 1 - i];
        a[a.length - 1 - i] = t;
    }
}

int[] a = // ...
whateverSort(a);
reverse(a);