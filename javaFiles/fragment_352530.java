public static double getHighNumber(double[] numbers) {
    double h = numbers[0];
    for (int i = 1; i < numbers.length; i++) {
        h = Math.max(h, numbers[i]);
    }
    return h;
}