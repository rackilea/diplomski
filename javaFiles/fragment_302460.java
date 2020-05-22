public static int factor (int num) {
    if (num % 2 == 0) return 2;
    for (int tst = 3 ; tst * tst <= num ; tst += 2)
        if (num % tst == 0)
            return tst;
    return num;
}