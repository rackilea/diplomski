private static void perm2(List<int[]> permutations, int[] a, int n) {
    if (n == 1) {
        permutations.add(a.clone());
        return;
    }
    for (int i = 0; i < n; i++) {
        swap(a, i, n-1);
        perm2(permutations, a, n-1);
        swap(a, i, n-1);
    }
}