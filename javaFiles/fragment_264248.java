int i = 0;
for (int[] rij : a) {
    int j = 0;
    for (int kol : rij) {
        if (i == j) {
            som += kol;
        }
        j++;
    }
    i++;
}