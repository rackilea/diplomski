import java.nio.ByteBuffer;

public class Test {

    public static void main(String[] args) {
        byte[] bytes = { 0x1, 0x1, 0x1, 0x1,  0x2b, 0x69, (byte) 0x80, 0x3f };
        ByteBuffer buffer = ByteBuffer.wrap(bytes);
        System.out.println(buffer.getFloat(4));
    }
}