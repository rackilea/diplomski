// Integers
if (scale == 0 && precision != 0) {
    if (precision < BYTE_PRECISION) {
        return Byte.class;
    }
    if (precision < SHORT_PRECISION) {
        return Short.class;
    }
    if (precision < INTEGER_PRECISION) {
        return Integer.class;
    }
    if (precision < LONG_PRECISION) {
        return Long.class;
    }

    // Default integer number
    return BigInteger.class;
}

// Non-integers
else {
    return BigDecimal.class;
}