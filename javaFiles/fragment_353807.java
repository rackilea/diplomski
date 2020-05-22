public class Cashier {
    public static final Random RANDOM = new Random();

    private int minAttentionTime, maxAttentionTime, endTime;

    /**
     * Constructs new Cashier with a range of possible attention time, in seconds
     * @param minAttentionTime in seconds
     * @param maxAttentionTime in seconds
     */
    public Cashier(int minAttentionTime, int maxAttentionTime) {
        this.minAttentionTime = minAttentionTime;
        this.maxAttentionTime = maxAttentionTime;
        endTime = 0;
    }

    /**
     * Register end time with a random attention time in the range.
     * @param currentTime the current time in seconds
     */
    public void attendNewClient(int currentTime) {
        endTime = currentTime + getRandomNumberInRange(minAttentionTime, maxAttentionTime);
    }

    /**
     * Returns if this cashier is available
     * @param currentTime the current time in seconds
     * @return true if this cashier is free, false otherwise
     */
    public boolean isFree(int currentTime) {
        return currentTime >= endTime;
    }

    /**
     * Returns a random number in range [min, max]
     * @param min the minimum number, inclusive
     * @param max the maximum number, inclusive
     * @return a random number in range [min, max]
     */
    private int getRandomNumberInRange(int min, int max) {
        return RANDOM.nextInt(max - min + 1) + min;
    }

    public String toString() {
        return String.valueOf(endTime);
    }
}