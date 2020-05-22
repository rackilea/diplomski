public class Measurements {
    private int[] data;

    public Measurements(int[] data) {
        this.data = data;
    }

    public Number performCalculation(Calculation c) {
        return c.performCalculation(data);
    }
}