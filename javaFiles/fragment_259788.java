public final class PackedUnsigned1616 {
    public final int field;

    private static final int RIGHT = 0xFFFF;

    public PackedUnsigned1616(int left, int right) {
        field = (left << 16) | (right & RIGHT);
    }

    public int getLeft() {
        return field >>> 16; // >>> operator 0-fills from left
    }

    public int getRight() {
        return field & RIGHT;
    }
}