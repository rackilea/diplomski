import java.nio.ByteBuffer;
import java.nio.ByteOrder;

class Test {
    public static void main(String[] args) {

        byte[] bytes = {(byte)0xa0,(byte)0xc7,(byte)0xa2,(byte)0xbc,(byte)0xd4};
        ByteBuffer wrapped = ByteBuffer.wrap(bytes);
        wrapped.order(ByteOrder.LITTLE_ENDIAN);
        System.out.println(wrapped.getInt(1) & 0x00000000ffffffffL);
    }
}