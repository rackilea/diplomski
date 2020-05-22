public static double[] getGravity() throws IOException {
    // same as before
}

// pass the already-computed gravity array to this method
public static double[] calcWeight(double[] gravity) {
    double earthWeight = 100.0;
    double[] weight = new double[8];
    double[] mass = new double[8];

    for (int a=0; a < 8; a++) {
        mass[a] = (earthWeight * 433.59237) / gravity[a];
        weight[a] = mass[a] * gravity[a];
    }
    return weight;
}

public static void PrintResults() throws IOException {
    double[] Gravity = getGravity();
    double[] Weight = calcWeight();

    // keep the rest as is
}