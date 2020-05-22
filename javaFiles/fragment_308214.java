try {
   outputs.add(future.get());
} catch (InterruptedException ie) {
   // always a good pattern if the thread that is waiting was interrupted
   Thread.currentThread().interrupt();
   return;
} catch (ExecutionException ee) {
   // somehow log the error
   logger.error("Computation failed to process", ee);
   // now continue and get the next future in the list
}