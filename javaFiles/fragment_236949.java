private volatile boolean isRunning = true;

@Override
public void run() {
    while (isRunning) {
        // Do work...
    }
}

public void stopThread() {
    isRunning = false;
}