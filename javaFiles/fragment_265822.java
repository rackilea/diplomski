public class DifferentialEvolution {

public static final double alpha = 0.001;

public static double evaluate(double x) {
    return -x*(x+1);
}

public static double max(int N) { // N is initial array size.

    double[] xs  = new double[N];

    for(int j = 0; j < N; j++) {
        xs[j] = Math.random()*1000.0 - 500.0; // Number from -500 to 500.
    }

    boolean done = false;
    while(!done) {
        for(int j = 0; j < N; j++) {
            double yj1 = xs[(int)(Math.random()*N)]; // This might include xs[j], but that shouldn't be a problem.
            double yj2 = xs[(int)(Math.random()*N)]; // It will only slow things down a bit.

            double cj = xs[j] + alpha*(yj1-yj2);

            if(evaluate(cj) > evaluate(xs[j])) {
                xs[j] = cj;
            }
        }

        double average = average(xs); // Edited

        done = true;
        for(int j = 0; j < N; j++) { // Edited
            if(!about(xs[j], average)) { // Edited
                done = false;
                break;
            }
        }

    }
    return average(xs);

}

public static double average(double[] values) {
    double sum = 0;
    for(int i = 0; i < values.length; i++) {
        sum += values[i];
    }

    return sum/values.length;

}

public static boolean about(double a, double b) {
    if(Math.abs(a - b) <= alpha /10000) { // This should work.
        return true;
    }
    return false;
}

public static void main(String[] args) {

    long t = System.currentTimeMillis();
    System.out.println(max(3));
    System.out.println("Time (Milliseconds): " + (System.currentTimeMillis() - t));

}