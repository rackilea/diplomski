s.shutdown();
try {
    if(!s.awaitTermination(3, TimeUnit.SECONDS)) {
          s.shutdownNow();
    }
} catch (InterruptedException e) {
    s.shutdownNow();
}