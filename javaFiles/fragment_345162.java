if (c < 100000) {
    int fac = 100000;
    for (int i = 0; i < array.length; i++) {
        array[i] = c % fac;
        fac /= 10;
    }
}