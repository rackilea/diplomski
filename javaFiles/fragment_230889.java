private void run() {
    double[] values = {9967,11281,10752,10576,2366,11882,11798};
    double variance = StatUtils.populationVariance(values);
    double sd = Math.sqrt(variance);
    double mean = StatUtils.mean(values);
    NormalDistribution nd = new NormalDistribution();
    for ( double value: values ) {
        double stdscore = (value-mean)/sd;
        double sf = 1.0 - nd.cumulativeProbability(Math.abs(stdscore));
        System.out.println("" + stdscore + " " + sf);
    }
}