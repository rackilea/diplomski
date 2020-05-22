/**
 * Compares two signed, big endian integers stored in a byte array at a specific offset.
 * @param n1 the buffer containing the first number
 * @param n1Offset the offset of the first number in the buffer
 * @param n2 the buffer containing the second number
 * @param n2Offset the offset in the buffer of the second number
 * @return -1 if the first number is lower, 0 if the numbers are equal or 1 if the first number is greater
 */
public final static byte compareSignedInteger(
        final byte[] n1, final short n1Offset,
        final byte[] n2, final short n2Offset) {

    // compare the highest order byte (as signed)
    if (n1[n1Offset] < n2[n2Offset]) {
        return -1;
    } else if (n1[n1Offset] > n2[n2Offset]) {
        return +1;
    }

    // compare the next bytes (as unsigned values)
    short n1Byte, n2Byte;
    for (short i = 1; i < 4; i++) {
        n1Byte = (short) (n1[(short) (n1Offset + i)] & 0xFF);
        n2Byte = (short) (n2[(short) (n2Offset + i)] & 0xFF);

        if (n1Byte < n2Byte) {
            return -1;
        } else if (n1Byte > n2Byte) {
            return +1;
        }
    }
    return 0;
}