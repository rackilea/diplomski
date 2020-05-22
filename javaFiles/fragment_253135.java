public class MaskingExample {

    private static final int OUTSIDE_POSITION = 0;
    private static final int HEATED_POSITION = 1;
    private static final int WET_POSITION = 2;
    private static final int TOTAL_CONDITIONS = 3;

    private BitSet bitSet = new BitSet(TOTAL_CONDITIONS);

    public boolean isOutside() {
        return bitSet.get(OUTSIDE_POSITION);
    }

    public void setOutside(boolean outside) {
        bitSet.set(OUTSIDE_POSITION, outside);
    }

    // Other setters and getters
}