public static double find_n_fact(int n) {
    double i, fact = 1;

    if(n < 0) // for negative numbers, factorial is nonsense.
        return -1;

    for (i = n; i > 1; i--)
        fact *= i;

    return fact;
}