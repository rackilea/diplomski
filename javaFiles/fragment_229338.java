public class RangeModel {

    private final int min;
    private final int max;
    private int value;

    public RangeModel(int min, int max) {
        this.min = min;
        this.max = max;
    }

    public int getMin() {
        return min;
    }

    public int getMax() {
        return max;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int newValue) {
        newValue = Math.max(getMin(), newValue);
        newValue = Math.min(getMax(), newValue);
        this.value = newValue;
    }

    public double getProgress() {

        int range = getMax() - getMin();
        int normalValue = getValue() - getMin();

        return (double)normalValue / ((double)range - 1);

    }

}