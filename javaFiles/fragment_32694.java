int [] randsample(int[] values, int numsamples, 
        boolean withReplacement, double [] pdf) {

    if(withReplacement) {
        double[] cdf = new double[pdf.length];
        cdf[0] = pdf[0];
        for(int i=1; i<pdf.length; i++) {
            cdf[i] = cdf[i-1] + pdf[i];
        }