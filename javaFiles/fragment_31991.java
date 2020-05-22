public class DiscreteRandom {

    private final double[] probDist;

    public DiscreteRandom(double... probs) {
        this.probDist = makeDistribution(probs);
    }

    private double[] makeDistribution(double[] probs) {
        double[] distribution = new double[probs.length];
        double sum = 0;
        for (int i = 0; i < probs.length; i++) {
            sum += probs[i];
            distribution[i] = sum;
        }
        return distribution;
    }

    public int nextInt() {
        double rand = Math.random();
        int i = 0;
        while (rand > probDist[i]) i++;
        return i;
    }

    /**
     * Simple test
     */
    public static void main(String[] args) {
        // We want 0 to come 3 times more often than 1.
        // The implementation requires normalized probability
        // distribution thus testProbs elements sum up to 1.0d.
        double[] testProbs = {0.75d, 0.25d};
        DiscreteRandom randGen = new DiscreteRandom(testProbs);

        // Loop 1000 times, we expect:
        // sum0 ~ 750
        // sum1 ~ 250
        int sum0 = 0, sum1 = 0, rand;
        for (int i = 0; i < 1000; i++) {
            rand = randGen.nextInt();
            if (rand == 0) sum0++;
            else           sum1++;
        }
        System.out.println("sum0 = " + sum0 + "sum1 = " + sum1);
    }
}