public static void main(String[] args) {
    System.out.println(getSliceQuantityinRange(35000000, 52000000, 100000));
}

private static double getSliceQuantityinRange(double min, double max, double step) {
    int range = (int)((max - min) / step);
    double scaled = randomGenerator.nextInt(range) * step;
    double shifted = scaled + min;
    return Double.valueOf((df.format(shifted)));
}