private static int[] toB(int[] res) {
    int[] bytes = new int[res.length * 2];
    for (int i = 0; i < res.length; ++i) {
        int value = res[i];
        int lo = value & 0xFF;
        int hi = (value >> 8) & 0xFF;
        bytes[2 * i] = (int)(byte) lo;
        bytes[2 * i + 1] = (int)(byte) hi;
    }
    return bytes;
}

private static int[] toI(int[] bytes) {
    int[] res = new int[bytes.length / 2];
    for (int i = 0; i < res.length; ++i) {
        int lo = (int) bytes[2 * i] & 0xFF;
        int hi = (int) bytes[2 * i + 1] & 0xFF;
        res[i] = lo | (hi << 8);
    }
    return res;
}

public static void main(String[] args) {
    int[] res = {176, 192, 312, 1028, 1064, 1016};
    int[] signed_byte_array = {-80, 0, -64, 0, 56, 1, 4, 4, 40, 4, -8, 3};
    System.out.println("b: " + Arrays.toString(toB(res)));
    System.out.println("i: " + Arrays.toString(toI(signed_byte_array)));
}