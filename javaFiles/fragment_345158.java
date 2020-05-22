ExecutorService service = ...

// Submit all your tasks
for (Task t : tasks) {
    service.submit(t);
}

service.shutdown();

// Wait for termination
boolean success = service.awaitTermination(5, TimeUnit.SECONDS);
if (!success) {
    // awaitTermination timed out, interrupt everyone
    service.shutdownNow();
}