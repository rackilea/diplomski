private static double[][] cholesky(double[][] a) {
    final int m = a.length;
    double epsilon = 0.000001; // Small extra noise value
    double[][] l = new double[m][m];
    for(int i = 0; i< m;i++){
        for(int k = 0; k < (i+1); k++){
            double sum = 0;
            for(int j = 0; j < k; j++){
                sum += l[i][j] * l[k][j];
            }
            l[i][k] = (i == k) ? Math.sqrt(a[i][i]+epsilon - sum) : // Add noise to diagonal values
                (1.0 / l[k][k] * (a[i][k] - sum));
        }
    }
    return l;
}