// The first int is the array length
    long[] array = new long[buf.getInt()];

    long next = 0;
    for (int i = 0; i < array.length; i++) {
        int delta = buf.getInt();
        if (delta <= 0) {
            // Negative sign means the value is encoded as int delta.
            next -= delta;
        } else {
            // Positive sign means the value is encoded as raw long.
            // Read the second (lower) part of long and combine it with the higher part.
            next = (long) delta << 32 | (buf.getInt() & 0xffffffffL);
        }
        array[i] = next;
    }