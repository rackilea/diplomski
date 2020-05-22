int i, j;

outerLoop: for (i = 0; i < 5; ++i) {
    for (j = 0; j < 5; ++j) {
        if (i == 2 && j == 2) {
            break outerLoop;
        }
    }
}