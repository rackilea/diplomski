WatchKey wk;
try {
   wk = ws.take();
} catch (InterruptedException ie) {
   // always recommended
   Thread.currentThread().interrupt();
   // leave the loop or maybe return from run()
   break;
}