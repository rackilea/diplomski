int getRandomNumberWithRangeProbability() {
    double range = Math.random();

    if (range < 0.5) {
        return randomWithRange(0, 20);
    } else if (range < 0.9) {
        return randomWithRange(21, 80);
    } else {
        return randomWithRange(81, 100);
    }
}

int randomWithRange(int min, int max) {
    int range = (max - min) + 1;
    return (int) (Math.random() * range) + min;
}