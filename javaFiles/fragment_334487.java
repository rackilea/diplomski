// The first int is the array length
    buf.putInt(array.length);

    long prev = 0;
    for (long next : array) {
        if (next - prev <= Integer.MAX_VALUE) {
            // Delta is small. Change the sign and encode as int.
            buf.putInt((int) (prev - next));
        } else {
            // Delta does not fit in 31 bits. Encode two parts of long.
            buf.putInt((int) (next >>> 32));
            buf.putInt((int) next);
        }
        prev = next;
    }