// a is in non-decreasing order, b is in non-increasing order.

public static int[] merge(int[] a, int[] b) {
    int[] ans = new int[a.length + b.length];
    int i = a.length - 1, j = 0, k = ans.length;

    while (k > 0)
        ans[--k] = 
            (j > b.length-1 || (i >= 0 && a[i] >= b[j])) ? a[i--] : b[j++];
    return ans;
 }