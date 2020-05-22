public class MaskingExample {

    private static final int OUTSIDE_MASK = 1; // Right-most bit
    private static final int HEATED_MASK = 1 << 1; // Second-to-right-most bit
    private static final int WET_MASK = 1 << 2; // Third-to-right-most bit

    private int value = 0;

    public boolean isOutside() {
        return isBitSet(OUTSIDE_MASK, value);
    }

    public void setOutside(boolean outside) {
        value = outside ? setBit(OUTSIDE_MASK, value) : unsetBit(OUTSIDE_MASK, value);
    }

    // Other setters and getters

    private static int setBit(int mask, int value) {
        return value | mask;
    }

    private static int unsetBit(int mask, int value) {
        return value & ~mask;
    }

    private static boolean isBitSet(int mask, int value) {
        return (value & mask) == mask;
    }
}