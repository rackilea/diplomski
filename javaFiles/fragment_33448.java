static int climb3(int n, boolean canMake3stepJump) {
    if (n < 0) {
        return 0;
    } else if (n == 0) {
        return 1;
    } else if (canMake3stepJump) {
        return climb3(n - 1, true) + climb3(n - 2, true) + 
               climb3(n - 3, false);
    } else {
        return climb3(n - 1, false) + climb3(n - 2, false);
    }
}