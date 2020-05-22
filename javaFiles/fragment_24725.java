import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.UUID;

public class Main {

  // expected from your question
  private static final int[] EXPECTED_BYTES = {
    185, 242, 54, 152, 140, 186, 166, 66, 184, 132, 46, 158, 237, 159, 185, 90
  };

  public static void main(String[] args) {
    UUID uuid = UUID.fromString("9836f2b9-ba8c-42a6-b884-2e9eed9fb95a");

    byte[] array = toByteArray(uuid);

    System.out.println("EXPECTED: " + Arrays.toString(EXPECTED_BYTES));
    System.out.println("ACTUAL  : " + Arrays.toString(toUnsignedInts(array)));
  }

  private static byte[] toByteArray(UUID uuid) {
    return ByteBuffer.allocate(16)
        .putLong(uuid.getMostSignificantBits())
        .putLong(uuid.getLeastSignificantBits())
        .array();
  }

  // for visual purposes only
  private static int[] toUnsignedInts(byte[] array) {
    int[] result = new int[array.length];
    for (int i = 0; i < array.length; i++) {
      result[i] = Byte.toUnsignedInt(array[i]);
    }
    return result;
  }
}