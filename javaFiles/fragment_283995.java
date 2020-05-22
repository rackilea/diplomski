private static int[] sequeezeLeft(final int[] a) {
    for (int i = 0; i < a.length; i++) {
        if (a[i] != 0) {
            for (int j = 0; j < a.length; j++) {
                if (a[j] == 0) {
                    a[j] = a[i];
                    a[i] = 0;
                }
            }
        }
    }
    return a;
}