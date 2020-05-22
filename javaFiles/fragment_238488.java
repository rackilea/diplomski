public MDArray(double[][] a) {
    mdarray = new double[a.length][];
    for (int i = 0; i < a.length; i++) {
        mdarray[i] = Arrays.copyOf(a[i], a[i].length);
    }
}