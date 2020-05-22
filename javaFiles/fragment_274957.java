public static long getShortUuid(UUID uuid) {
    long result = uuid.getMostSignificantBits();
    result = result - BT_UUID_UPPER_BITS;
    result = result >> 32;
    return result;
}