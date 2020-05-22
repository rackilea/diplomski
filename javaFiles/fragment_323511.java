import java.util.Random;

class Main {

    public static int getOneNumber(double[] probs, Random rnd) {
        double r = rnd.nextDouble();
        for (int j = 0; j < probs.length; j++) {
            if (r < probs[j]) {
                return j;
            }
            r -= probs[j];
        }
        throw new RuntimeException("probabilities should sum to 1");
    }


    public static void main(String[] args) {

        // Desired probabilities
        double[] probabilities = {
            0.05, // 0
            0.15, // 1
            0.6, // 2
            0.15, // 3
            0.05 }; // 4

        Random rnd = new Random();
        for (int i = 0; i < 20; i++) {
            System.out.println(getOneNumber(probabilities, rnd));
        }
    }
}