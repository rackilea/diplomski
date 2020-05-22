public double getAverage() {
    int sum = 0;

    for (int value : values) {
        sum += value;
    }

    return (sum / (double) values.length);
}