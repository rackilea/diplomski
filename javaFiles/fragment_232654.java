public class Perceptron {
    double[] weights = new double [3];

    public Perceptron() {
        for (int i = 0; i<weights.length; i++){
            weights[i] = randomNumber(-1, 1);
        }
    }

    public double guess(double[] inputs){
        double sum = 0;
        for (int i = 0; i < weights.length; i++){
            sum += weights[i]*inputs[i];
        }
        double myguess = Math.signum(sum);
        return myguess;
    }

    public double randomNumber(int min, int max) {
        double d = Math.random()*(max - min) + min;
        return d;
    }
}