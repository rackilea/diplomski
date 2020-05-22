120     private static void runLater(final Runnable r, boolean exiting) {
  121         if (!initialized.get()) {
  122             throw new IllegalStateException("Toolkit not initialized");
  123         }
  124 
  125         pendingRunnables.incrementAndGet();
  126         waitForStart();
  127 
  128         if (SystemProperties.isDebug()) {
  129             Toolkit.getToolkit().pauseCurrentThread();
  130         }
  131 
  132         synchronized (runLaterLock) {
  133             if (!exiting && toolkitExit.get()) {
  134                 // Don't schedule a runnable after we have exited the toolkit
  135                 pendingRunnables.decrementAndGet();
  136                 return;
  137             }
  138 
  139             Toolkit.getToolkit().defer(new Runnable() {
  140                 @Override public void run() {
  141                     try {
  142                         r.run();
  143                         pendingRunnables.decrementAndGet();
  144                         checkIdle();
  145                     } catch (Throwable t) {
  146                         System.err.println("Exception in runnable");
  147                         t.printStackTrace();
  148                     }
  149                 }
  150             });
  151         }
  152     }