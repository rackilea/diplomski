public static double sigmoid(double t) {
    return 1 / (1 + Math.pow(Math.E, (-1 * t)));
}

public static double[][] sigmoid(double[][] x, boolean deriv) {
    double[][] = result = new double[x.length][x[0].length];

    for (int i = 0; i < x.length; i++) {
        for (int j = 0; j < x[i].length; j++) {
            double sigmoidCell = sigmoid(x[i][j]);

            if (deriv == true) {
                result[i][j] = sigmoidCell * (1 - sigmoidCell);
            } else {
                result[i][j] = sigmoidCell;
            }
        }
    }

    return result;
}