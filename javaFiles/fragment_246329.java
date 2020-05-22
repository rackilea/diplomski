public static int isSmart(int n) {
    int smart = 1;
    for (int i = 1; smart < n; i++) {
        smart = smart + i;
    }
    return smart == n ? 1 : 0;
}