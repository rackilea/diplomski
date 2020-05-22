private void reduce() {
    int gcd = gcd(noemer, teller);
    noemer /= gcd;
    teller /= gcd;
}

private int gcd(int a, int b) {
    return b == 0 ? a : gcd(b, a % b);
}