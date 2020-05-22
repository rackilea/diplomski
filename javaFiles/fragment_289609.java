import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class ByteArrayTest {

  public static void main(String[] args) {
    byte[] value1 = new byte[16];
    byte[] value2 = new byte[16];
    byte[] finalvalue = new byte[value1.length + value2.length];
    long ts = System.currentTimeMillis();
    int val = 100;

    ByteBuffer.wrap(value1).order(ByteOrder.LITTLE_ENDIAN).asLongBuffer()
        .put(ts);
    ByteBuffer.wrap(value2).order(ByteOrder.LITTLE_ENDIAN).asIntBuffer()
        .put(val);

    System.arraycopy(value1, 0, finalvalue, 0, value1.length);
    System.arraycopy(value2, 0, finalvalue, value1.length, value2.length);

    printByteArray(finalvalue);
  }

  private static void printByteArray(final byte[] array) {
    StringBuilder sb = new StringBuilder(array.length);
    for (byte b : array) {
      sb.append(String.format("%02X", b));
    }
    System.out.println(sb.toString());
  }
}