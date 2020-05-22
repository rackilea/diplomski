public static double[] whiteNoise(int length) {
    double[] out = new double[length];
    for (int i = 0; i < length; i++) {
        out[i] = (Math.random() * 2 - 1.0)/2.0;
    }
    return out;
}