public double total() {
    double temp = 1;
    double sum = 0;
    for (int a = 0; a < 16; a++) {
        sum += temp;
        temp *= this.b;
    }
    return sum;
}