static double[] sigmoid(double[] data) {
    double[] z = Arrays.copyOf(data, data.length);
    for (int i = 0; i < z.length; i++)
        z[i] = 1 / (1 + Math.exp(-z[i]));
    return z;
}