public class StepFunction implements ActivationFunction {
    @Override
    public float get() {return (x < 0) ? 0f : 1f;}
}

public class SigmoidFunction implements ActivationFunction {
    @Override
    public float get() {return StrictMath.tanh(h);}
}