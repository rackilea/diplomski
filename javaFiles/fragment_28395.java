public class StepFunction implements ActivationFunction {
    @Override
    public float get(float x) {return (x < 0) ? 0f : 1f;}

    @Override
    public float firstDerivative(float x) {return 1;}
}

public class SigmoidFunction implements ActivationFunction {
    @Override
    public float get(float x) {return StrictMath.tanh(x);}

    // derivative_of tanh(x) = (4*e^(2x))/(e^(2x) + 1)^2 == 1-tanh(x)^2 
    @Override
    public float firstDerivative(float x) {return 1 - Math.pow(StrictMath.tanh(x), 2);}
}