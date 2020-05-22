static Double f1(XValues xValues) {
    try {
        return 5 * xValues.getX1() + xValues.getX2() + 3 * xValues.getX3();
    } catch (IllegalArgumentException e) {
        return null;
    }
}