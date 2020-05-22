for (Future<Void> future : futures)
{
    if (future.isDone()) {
        try {
            System.out.println("Getting future");
            future.get();
        } catch (CancellationException ce) {

        } catch (ExecutionException ee) {

        }
    } else {
        System.out.println("The future is not done, cancelling it");
        if (future.cancel(true)) {
            System.out.println("task was cancelled");
        } else {
            //handle case when FutureTask#cancel(boolean mayInterruptIfRunning) wasn't cancelled
        }
    }
}