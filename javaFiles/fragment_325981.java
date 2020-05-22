int a[] = {1, 2, 6, 7, 10};
    int b[] = {2, 3, 4, 8, 9};
    int[] ans = new int[a.length + b.length];
    int i = a.length - 1;
    int j = b.length - 1;
    int k = a.length + b.length - 1;
    while (k >= 0) {
        if (j < 0) {
            while (i >= 0) {
                ans[k--] = a[i--];
            }
        } else if (i < 0) {
            int l = 0;
            while (l <= j) {
                ans[k--] = b[l++];
            }
        } else {
            while (a[i] >= b[j]) {
                ans[k--] = a[i--];
            }
            int m = j;
            int n = j;
            while (j >= 0 && b[j] >= a[i]) {
                j--;
            }
            m = j + 1;
            for (int e = m; e <= n; e++) {
                ans[k--] = b[e];
            }
        }
    }
    System.out.println(Arrays.toString(ans));