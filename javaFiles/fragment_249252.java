import java.util.Random;

public class Perceptron {
    double[] weights;
    double threshold;
    public void Train(double[][] inputs, int[] outputs, double threshold, double lrate, int epoch) {
        this.threshold = threshold;
        int n = inputs[0].length;
        int p = outputs.length;
        weights = new double[n];
        Random r = new Random();

        //initialize weights
        for(int i=0;i<n;i++) {
            weights[i] = r.nextDouble();
        }

        for(int i=0;i<epoch;i++) {
            int totalError = 0;
            for(int j =0;j<p;j++) {
                int output = Output(inputs[j]);
                int error = outputs[j] - output;

                totalError +=error;

                for(int k=0;k<n;k++) {
                    double delta = lrate * inputs[j][k] * error;
                    weights[k] += delta;
                }
            }
            if(totalError == 0)
                break;
        }
    }

    public int Output(double[] input) {
        double sum = 0.0;
        for(int i=0;i<input.length;i++) {
            sum += weights[i]*input[i];
        }

        if(sum>threshold)
            return 1;
        else
            return 0;
    }

    public static void main(String[] args) {
        Perceptron p = new Perceptron();
        double inputs[][] = {{0,0},{0,1},{1,0},{1,1}};
        int outputs[] = {0,0,0,1};

        p.Train(inputs, outputs, 0.2, 0.1, 200);
        System.out.println(p.Output(new double[]{0,0})); // prints 0
        System.out.println(p.Output(new double[]{1,0})); // prints 0
        System.out.println(p.Output(new double[]{0,1})); // prints 0
        System.out.println(p.Output(new double[]{1,1})); // prints 1
    }
}