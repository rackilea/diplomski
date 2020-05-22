int[] numsToGenerate           = new int[]    { 1,   2,    3,   4,    5   };
double[] discreteProbabilities = new double[] { 0.1, 0.25, 0.3, 0.25, 0.1 };

EnumeratedIntegerDistribution distribution = 
    new EnumeratedIntegerDistribution(numsToGenerate, discreteProbabilities);

int numSamples = 100;
int[] samples = distribution.sample(numSamples);