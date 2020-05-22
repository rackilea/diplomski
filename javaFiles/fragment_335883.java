ArrayList<double[]> observed = new ArrayList<>();
for (int j = 0; j< featurevec.length; j++) {
    double[] f = new double[2]; //move this here
    for (int i = 0; i< featurevec[j].getNumElements(); i++) {
        if (featurevec[j].get(i) == 0) //I recommend changing this
            f[0]++;
        else
            f[1]++;
    }
    observed.add(f);
}