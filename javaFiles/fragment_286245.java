...

private double[] weightedDeltaHidden;

...

Output_Neuron(int hiddenNeurons) {

    ...

    this.weightedDeltaHidden = new double[hiddenNeurons];
}

...

void tuneWeights(double LR, double[] hidden_output, int target) {
    double delta = (target - output) * f.dSigmoid(output);
    for (int i = 0; i < weights.length; i++) {
        weights[i] += delta_weights(i, LR, delta, hidden_output);
    }
}

double delta_weights(int i, double LR, double delta, double[] hidden_output) {
    weightedDeltaHidden[i] = delta * weights[i]; // weightedDeltaHidden is the product of delta of this output neuron and the weight of the i-th hidden neuron.
                                                 // That value is needed when the weights of the hidden neurons are tuned...
    return LR * delta * hidden_output[i];
}

...

double[] getWeightedDeltaHidden() {
    return weightedDeltaHidden;
}