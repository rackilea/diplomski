public static class Blah {
    @BoundNumber(size="32", byteOrder = ByteOrder.BigEndian)
    private int size;

    @Init
    public void go() {
        size = size * 3;
    }
}