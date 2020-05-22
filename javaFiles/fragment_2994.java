import java.util.concurrent.*;

class UsedTrackingSemaphore extends Semaphore {
    private int originalPermits;

    public UsedTrackingSemaphore(int permits) {
        super(permits);
        originalPermits = permits;
    }

    public UsedTrackingSemaphore(int permits, boolean fair) {
        super(permits, fair);
        originalPermits = permits;
    }

    public int usedPermits() {
        return originalPermits - availablePermits();
    }
}