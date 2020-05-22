int NN = N / x;
int MM = M / x;

for (n = 1; n <= NN; n++) {
    for (m = 1; m <= MM; m++) {
        if (gcd(m, n) == 1) count++;
    }
}