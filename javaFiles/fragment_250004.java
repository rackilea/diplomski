import java.nio.*;

public class Test {
    public static void main(String[] args) throws Exception {
        ShortBuffer buffer = ShortBuffer.allocate(100);
        short[] data = new short[5];
        buffer.put(data);
        System.out.println(buffer.capacity()); // Prints 100
        System.out.println(buffer.position()); // Prints 5
    }
}