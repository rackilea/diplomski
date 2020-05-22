public static double evalHornerRec(double[] a, double x) {
    int len = a.length;   
    if (len <= 0) {   
        return 0.0;
    } else {   
        double[] subArray = Arrays.copyOf(a,len-1);
        return evalHornerRec(subArray, x) + a[len-1] * Math.pow(x, len-1);
    }   
}