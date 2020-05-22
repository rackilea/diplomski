public static double[][] amountOTP(double [][] a, int x){
    a = Arrays.copyOf(a, x);
    for(int i=0; i<a.length; i++) {
        if(a[i] != null) {
            a[i] = Arrays.copyOf(a[i], x);
        } else {
            a[i] = new double[x]; // allows growth
        }
    }
    return a;
}