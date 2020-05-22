public static void main(String[] args) {
    int[] a = {1, 2, 3, 4, 5, 6};
    System.out.println(sum(a, 6, 7)); // ==> true
}

public static boolean sum(int[] A, int n, int k) //where k is the sum needed and n the size of the array
{
    if (k <= A[0] || k >= A[n - 1] * 2) {
        return false;
    }
    int i = 0;
    int j = n - 1;
    return sum_Recursion(A, n, k, i, j);
}


private static boolean sum_Recursion(int[] A, int n, int k, int i, int j) {
    if (i == j) {
        return false;
    } else if ((A[i] + A[j]) == k) {
        return true;
    } else if ((A[i] + A[j]) > k) {
        return sum_Recursion(A, n, k, i, j - 1);
    }
    return sum_Recursion(A, n, k, i + 1, j);
}