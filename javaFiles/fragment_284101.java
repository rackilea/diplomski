import java.nio.ByteBuffer;

public class Main {

    static ByteBuffer longBuf = ByteBuffer.allocate(8);

    public static long getLong(ByteBuffer bb) {
        // Fill with eight 0-bytes and set position.
        longBuf.putLong(0, 0).position(8 - bb.remaining());

        // Put the remaining bytes from bb, and get the resulting long.
        return longBuf.put(bb).getLong(0);
    }

    public static void main(String[] args) {

        ByteBuffer bb = ByteBuffer.allocate(10);

        // Add 2 bytes
        bb.put((byte) 5);
        bb.put((byte) 7);

        // Prepare to read
        bb.flip();

        long l = getLong(bb);
        System.out.println(Long.toBinaryString(l)); // Prints 10100000111

        // Correct since, 00000101 00000111
        //               |--------|--------|
        //                       5        7
    }
}