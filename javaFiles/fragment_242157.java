private Runnable target; // This is what you passed to the constructor

@Override
public void run() {
  if (target != null) {
    target.run();
  }
}