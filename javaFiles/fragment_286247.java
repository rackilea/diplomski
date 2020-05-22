void train(int[] inputs, int target) {

    ...

    //tune Hidden weights
    for (int i = 0; i < numOfHiddenNeurons; i++) {
        double weightedDeltaHiddenTotal = 0;
        for (int j = 0; j < numOfOutputNeurons; j++) {
            weightedDeltaHiddenTotal += output_neurons[j].getWeightedDeltaHidden()[i]; // weightedDeltaHiddenTotal is the sum of the weightedDeltaHidden over all output neurons. Each weightedDeltaHidden
        }                                                                              // is the product of delta of the j-th output neuron and the weight of the i-th hidden neuron.
        hidden_neurons[i].tuneWeights(LR, inputs, weightedDeltaHiddenTotal);
    }
}