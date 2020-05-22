class Test {
    static void sort (int a[], int b[], int m, int n) {
        // Start at correct offset for target array.

        int e = m + n + 1;

        // Until one list empty, choose the correct value.

        while (m >= 0 && n >= 0)
            if (a[m] >= b[n])
                a[e--] = a[m--];
            else
                a[e--] = b[n--];

        // If b was empty, just transfer a.

        while (m >= 0)
            a[e--] = a[m--];

        // If a was empty, just transfer b.

        while (n >= 0)
            a[e--] = b[n--];
    }