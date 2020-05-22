public static double evalHornerRec(double[] a, double x) { 
    if (a.length == 1) {   
        return a[0];
    } else {   
        double[] subArray = new double[a.length - 1];
        System.arraycopy(a, 1, subArray, 0, subArray.length);
        return a[0] + x * evalHornerRec(subArray, x);
    }   
}