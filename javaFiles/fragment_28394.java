public class Neuron {
    private final ActivationFunction actFunc;
    // other fields...

    public Neuron(ActivationFunction actFunc) {
        this.actFunc = actFunc;
    }

    public float fire(){
        // ...
        out = actFunc.get(pot);
        return out;
    } 
}