public static double[] redNoise(int length, int m) {
    double out[] = whiteNoise(length);

    for (int i=0; i<length/m-1; i++) {
        int k = i*m;
        int l = ((i+1)*m <= length-1) ? (i+1)*m : length-1;
        double d = (out[l] - out[k])/((double)(m));
        for (int j=0; j<m; j++) {
            out[k+j] = out[k] + d*j;
        }
    }
    return out;
}