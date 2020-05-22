private final ExecutorService es = Executors.newSingleThreadExecutor();

public void sendRunnable(Runnable run) {
    es.submit(run);
}

public void sendCommand(Command command) {
    es.submit(new Runnable() {
       public void run() {
           try {
               command.call();
           } catch (Throwable t) {
               t.printStackTrace();
           }
       }
   });
}