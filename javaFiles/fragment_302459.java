public static int factor (int num) {   
    for (int tst = 2 ; tst * tst <= num ; tst++)
        if (num % tst == 0)
            return tst;
    return num;
}