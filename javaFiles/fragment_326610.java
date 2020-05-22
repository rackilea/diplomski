public static double[][] insertRow(double[][] m, int r, double[] data) {
    double[][] out = new double[m.length + 1][];
    for (int i = 0; i < r; i++) {
        out[i] = m[i];
    }
    out[r] = data;
    for (int i = r + 1; i < out.length; i++) {
        out[i] = m[i - 1];
    }
    return out;
}