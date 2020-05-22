/**
 * Specialized variant of ThreadPoolExecutor.execute for delayed tasks.
 */
private void delayedExecute(Runnable command) {
    if (isShutdown()) {
        reject(command);
        return;
    }
    // ...
}