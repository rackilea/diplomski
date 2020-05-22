public static long factor (long num) {
    if (num % 2 == 0) return 2;
    if (num % 3 == 0) return 3;
    for (int tst = 5, add = 2 ; tst * tst <= num ; tst += add, add = 6 - add)
        if (num % tst == 0)
            return tst;
    return num;
}