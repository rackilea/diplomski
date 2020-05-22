private int encode( byte[] array, int offset, int value ) {
    if (value < 0)
        throw new InvalidParameterException("Value " + value + " is negative and cannot safely be decoded.");
    byte temp;
    int shift = 28;
    // find highest set septet
    while(shift > 0 && (value >> shift) == 0) {
        shift -= 7;
    }
    // encode parts that have a successor
    while(shift > 0) {
        array[offset++] = (byte)(((value >> shift) & 0x7F) | 0x80);
        shift -= 7;
    }
    // last septet
    array[offset++] = (byte)(value & 0x7F);
    // return offset for next value
    return offset;
}