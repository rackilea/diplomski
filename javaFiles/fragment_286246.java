...

void tuneWeights(double LR, int[] inputs, double weightedDeltaHiddenTotal) {
    for (int i = 0; i < weights.length; i++) {
        weights[i] += delta_weights(LR, inputs[i], weightedDeltaHiddenTotal);
    }
}

private double delta_weights(double LR, double input, double weightedDeltaHiddenTotal) {
    double deltaOutput = f.dSigmoid(output) * weightedDeltaHiddenTotal;
    return LR * deltaOutput * input;
}

...