public class SeedGettableRandom {
    long seed;
    public SeedGettableRandom(long initialSeed) {
        this.seed = initialSeed;
    }
    public void nextBytes(byte[] bytes) {
        Random rand = new Random(seed);
        rand.nextBytes(bytes);
        seed = rand.nextLong();
    }
    // analogous methods for the rest of Random's methods.
    public long getSeed() {
        return seed;
    }
}