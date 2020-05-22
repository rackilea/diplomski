public double getTotal(double[] finalTotal) {
    for (int i; i < finalTotal.length; i++) {
        sum = finalTotal[i] + sum;
    }
    return sum;
}