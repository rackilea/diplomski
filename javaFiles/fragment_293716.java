public Random(long seed) {
    if (getClass() == Random.class)
        this.seed = new AtomicLong(initialScramble(seed));
    else {
        // subclass might have overriden setSeed
        this.seed = new AtomicLong();
        setSeed(seed);
    }
}

private static long initialScramble(long seed) {
    return (seed ^ multiplier) & mask; // (seed XOR multiplier) AND mask
}