// Warning: only do this if there is no better option

public static void main(String[] args) {
    ByteBuffer bb = ByteBuffer.allocateDirect(128);
    long addr = ((DirectBuffer) bb).address();

    ByteBuffer bb2 = wrapAddress(addr, bb.capacity());

    bb.putLong(0, 0x12345678);
    System.out.println(Long.toHexString(bb2.getLong(0)));
}

static final Field address, capacity;
static {
    try {
        address = Buffer.class.getDeclaredField("address");
        address.setAccessible(true);
        capacity = Buffer.class.getDeclaredField("capacity");
        capacity.setAccessible(true);

    } catch (NoSuchFieldException e) {
        throw new AssertionError(e);
    }
}

public static ByteBuffer wrapAddress(long addr, int length) {
    ByteBuffer bb = ByteBuffer.allocateDirect(0).order(ByteOrder.nativeOrder());
    try {
        address.setLong(bb, addr);
        capacity.setInt(bb, length);
        bb.clear();
    } catch (IllegalAccessException e) {
        throw new AssertionError(e);
    }
    return bb;
}