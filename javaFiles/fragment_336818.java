public class BackPropagationStrategy implements IStrategy, Serializable {

    [...]

    public void updateWeightsAndBias(NeuralNetwork neuralNetwork, double[] inputs) {

        for (int i = neuralNetwork.getLayers().size() - 1; i >= 0; i--) {

            Layer layer = neuralNetwork.getLayers().get(i);

            for (Neuron neuron : layer.getNeurons()) {

                [...]

                Synapse bias = neuron.getBias();
                double delta = learning * 1.0;
                bias.setWeight(bias.getWeight() + delta + this.momentum * bias.getDelta());

                bias.setDelta(delta);
            }
        }
    }

    [...]