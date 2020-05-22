public class PrimeRunnableMain {

    public static void main(String[] args) {
        PrimeRunnable.setUpperBorder(10);
        PrimeRunnable primeRunnable1 = new PrimeRunnable();
        PrimeRunnable primeRunnable2 = new PrimeRunnable();
        PrimeRunnable primeRunnable3 = new PrimeRunnable();
        PrimeRunnable primeRunnable4 = new PrimeRunnable();
        primeRunnable1.start();
        primeRunnable2.start();
        primeRunnable3.start();
        primeRunnable4.start();
    }
}