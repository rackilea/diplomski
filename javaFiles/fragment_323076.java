public static boolean IsItPalin(int sPrime) {
    int sPrimeBackup = sPrime;
    int reverse = 0;

    while (sPrime > 0) {
        reverse = reverse * 10 + sPrime % 10;
        sPrime = sPrime / 10;
    }

    return (sPrimeBackup == reverse);
}