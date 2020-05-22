double frequency = findFrequency(lowPassFilter(signal));

private double findFrequency(double[] signal) {
    int[] signs = new int[signal.length];
    for (int i = 0; i < signal.length - 1; i++) {
        double diff = signal[i+1] - signal[i];
        if (diff < 0) {
            signs[i] = -1;
        } else if (diff == 0) {
            signs[i] = 0;
        } else {
            signs[i] = 1;
        }
    }
    int[] secondDerivatives = new int[signs.length];
    for (int i = 0; i < signs.length - 1; i++) {
        secondDerivatives[i] = signs[i+1] - signs[i];
    }
    double biggestSoFar = 0.0;
    int indexOfBiggestSoFar = 0;
    for (int i = 0; i < secondDerivatives.length; i++) {
        if (secondDerivatives[i] == -2 && signal[i] > biggestSoFar) {
            biggestSoFar = signal[i];
            indexOfBiggestSoFar = i;
        }
    }
    return 1 / (double)indexOfBiggestSoFar * AudioListener.SAMPLE_RATE;
}

private double[] lowPassFilter(double[] signal) {
    double alpha = 0.15;
    for (int i = 1; i < signal.length; i++ ) {
        signal[i] = signal[i] + alpha * (signal[i] - signal[i-1]);
    }
    return signal;
}