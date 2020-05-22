private static long[] unpack(long packed) {
    long a = (packed % PACK);
    long b = (packed / PACK) % PACK;
    long c = (packed / (PACK * PACK));  // Use / not %.
    return new long[]{a, b, c};
}