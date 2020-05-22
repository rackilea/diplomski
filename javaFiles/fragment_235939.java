class MultiExecutorShutdown
{
     private final List<InterrupedException> exceptions = new ArrayList<>();

     public void shutdown(ExecutorService service)
     {
         try {
             if (!executor.awaitTermination(1, TimeUnit.SECONDS)) {
                executor.shutdownNow();
             }
         } catch (InterruptedException ex) {
             exceptions.add(ex);
         }
     }

     public Optional<InterruptedException> getLastException()
     {
         if (exceptions.isEmpty()) {
            return Optional.empty();
         } else {
             return exceptions.get(exceptions.size() - 1);
         }
     }

     public Optional<InterruptedException> getFirstException()
     {
         if (exceptions.isEmpty()) {
            return Optional.empty();
         } else {
             return exceptions.get(0);
         }
     }
}


[...]
MultiExecutorShutdown multiShutdown = new MultiExecutorShutdown();
multiShutdown.shutdown(executor1);
multiShutdown.shutdown(executor2);
multiShutdown.shutdown(executor3);

Optional<InterruptedException> exception = multiShutdown.getLastException();
// alternative:
// Optional<InterruptedException> exception = multiShutdown.getFirstException();

if (exception.isPresent()) {
   throw new IllegalStateException(exception.get());
}