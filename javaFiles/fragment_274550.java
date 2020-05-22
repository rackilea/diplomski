// Consumer
private final Semaphore semaphore = new Semaphore(0, true);

public void requestRes() throws InterruptedException {    
    if(!semaphore.tryAcquire(Config.STARVE_TIME_SECONDS, TimeUnit.SECONDS))
        return; // No resource available, and timed out

    Resource resource = resources.removeFirst();
}

// Producer, giving out as many semaphores as resources produced
semaphore.release(resources.size());