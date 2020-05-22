private boolean hasMovement() {
    return sensore.getStatoSensore() == 1;
}

private static void waitSecond() {
    try {
        Thread.sleep(1000);
    } catch (InterruptedException e) {
    }
}

public void run() {
    while (true) {
        // Wait until movement noticed
        while (!hasMovement()) {
            waitSecond();
        }
        // Movement noticed, turn light on
        lampada.accendi();

        long lastMovementTime = System.currentTimeMillis();
        // Wait until 10 seconds from last movement
        while (System.currentTimeMillis() < lastMovementTime + (timeoutSpegnimento * 1000)) {
            if (hasMovement()) {
                lastMovementTime = System.currentTimeMillis();
            }
            waitSecond();
        }

        // Turn light off
        lampada.spegni();
    }