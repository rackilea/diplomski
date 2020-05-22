public double sum() {
    double sum = 0;
    for(Double entry : stack) {
        sum += entry.doubleValue();
    }
    return sum;
}