public void shutdownQuietly(ExecutorService executor)
{
    try {
        if (!executor.awaitTermination(1, TimeUnit.SECONDS)) {
            executor.shutdownNow();
        }
    } catch (InterruptedException ex) {
       /* IGNORE */
    }  
}