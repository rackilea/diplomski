for (int i = x; i < y; i++) {
    cont1 = 0;
    for (int j = 1; j < i; j++) {
        if (i % j == 0) {
            cont1 += j;
        }
    }

    if (cont1 == i) {
        perfect += 1;
    } else if (cont1 < i) {
        deficient += 1;
    } else {
        abundant += 1;
    }
}