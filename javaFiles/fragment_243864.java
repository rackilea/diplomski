import java.nio.ByteBuffer; import java.nio.ByteOrder; import java.nio.IntBuffer;

public class Test {
    static final int bytes_per_datum = 4;

    public static void main(String args[]) {
        main2("Native Endian", ByteOrder.nativeOrder());
        main2("Big Endian", ByteOrder.BIG_ENDIAN);
        main2("Little Endian", ByteOrder.LITTLE_ENDIAN);
    }

    static void main2(String comment, ByteOrder endian) {
        int[] data = { 1, 0xF, 0xFF, 0xFFF, 0xFFFF, 0xFFFFF, 0xFFFFFF, 0xFFFFFFF, 0xFFFFFFFF };
        ByteBuffer bb = ByteBuffer.allocateDirect(data.length * bytes_per_datum);
        bb.order(endian); // endian must be set before putting ints into the buffer
        put_ints(bb, data);

        System.out.println(comment + ": ");
        print(bb);
    }

    static void put_ints(ByteBuffer bb, int[] data) {
        IntBuffer b = bb.asIntBuffer(); // created IntBuffer starts only from the ByteBuffer's relative position
                                        // if you plan to reuse this IntBuffer, be mindful of its position
        b.put(data); // position of this IntBuffer changes by +data.length;
    } // this IntBuffer goes out of scope

    static void print(ByteBuffer bb) { // prints from start to limit
        ByteBuffer bb_2 = bb.duplicate(); // shares backing content, but has its own capacity/limit/position/mark (equivalent to original buffer at initialization)
        bb_2.rewind();
        for (int x = 0, xx = bb_2.limit(); x < xx; ++x) {
            System.out.print((bb_2.get() & 0xFF) + " "); // 0xFF for display, since java bytes are signed
            if ((x + 1) % bytes_per_datum == 0) {
                System.out.print(System.lineSeparator());
            }
        }
    }
}