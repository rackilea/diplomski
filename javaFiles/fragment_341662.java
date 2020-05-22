public class TestBitToByteEncoder {

    public static void main(String[] args) {
        int[] bits = new int[]{1, 0, 1, 0, 1, 1, 0, 1, 0, 1};
        byte[] bytes = encodeToByteArray(bits);
    }

    private static byte[] encodeToByteArray(int[] bits) {
        byte[] results = new byte[(bits.length + 7) / 8];
        int byteValue = 0;
        int index;
        for (index = 0; index < bits.length; index++) {

            byteValue = (byteValue << 1) | bits[index];

            if (index %8 == 7) {
                results[index / 8] = (byte) byteValue;
            }
        }

        if (index % 8 != 0) {
            results[index / 8] = (byte) byteValue << (8 - (index % 8));
        }

        return results;
    }
}