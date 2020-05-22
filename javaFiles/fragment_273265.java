private void finishScheduledExecutor() {
    if (periodicTask != null) {
        periodicTask.cancel(false); // true if it can be interrupted, false if you'd like it 
                              // to finish its current iteration
    }
    if (executor != null) {
        executor.shutdown(); // shutdown will allow the final iteration to finish 
                             // executing where shutdownNow() will kill it immediately
    }
}