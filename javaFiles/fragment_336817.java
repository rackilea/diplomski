public class Neuron implements Serializable {

    [...]

    private Synapse bias;

    public Neuron(IActivation activation) {
        [...]
        this.bias = new Synapse(this);
        this.bias.setWeight(0.5); // Set initial weight OR keep the random number already set
    }

    public void updateOutput(double[] inputs) {
        double sumWeights = this.calculateSumWeights(inputs);

        this.output = this.activation.activate(sumWeights + this.bias.getWeight() * 1.0);
    }

    [...]