static boolean check(int B[], int m) {
    int i = 0;
    while (i < B.length) {
        if (m == B[i]) {
            return true;
        }
        i++;
    }
    return false;
}