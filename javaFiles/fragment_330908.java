public class Calc extends Thread {

    private int[] array;
    private double sum;

    public Calc(int[] array) {
        this.array = array;
        this.sum = 0;
    }

    @Override
    public void run() {
        for (int i = 0; i < array.length; i++) {
            sum += Math.sqrt(array[i]);
        }
    }

    public double getSum() {
        return this.sum;
    }
}