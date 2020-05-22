// using `AtomicBoolean` which wraps a `volatile boolean` but is const object
// NOTE: we _can't_ synchronized on Boolean, needs to be constant object reference
private final AtomicBoolean pauseFlag = new AtomicBoolean(false);
...
while (!Thread.currentThread().isInterrupted()) {
    if (pauseFlag.get()) {
       synchronized (pauseFlag) {
          // we are in a while loop here to protect against spurious interrupts
          while (pauseFlag.get())) {
             try {
                pauseFlag.wait();
             } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                // we should probably quit if we are interrupted?
                return;
             }
          }
       }
    }
    ...
}
...
public void pause() {
   pauseFlag.set(true);
}
...
public void resume() {
   pauseFlag.set(false);
   synchronized (pauseFlag) {
       pauseFlag.notify();
   }
}