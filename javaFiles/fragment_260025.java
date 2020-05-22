public static void main(String[] args) {
    String appId = "myapplicationid";
    boolean alreadyRunning;
    try {
        JUnique.acquireLock(appId);
        alreadyRunning = false;
    } catch (AlreadyLockedException e) {
        alreadyRunning = true;
    }
    if (!alreadyRunning) {
        // Start sequence here
    }
}