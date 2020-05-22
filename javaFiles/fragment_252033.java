while (fxToolkitRunning()) {
    Runnable runnable = runnableQueue.take(); // block until something available
    acquireLock();
    runnable.run();
    releaseLock();
}