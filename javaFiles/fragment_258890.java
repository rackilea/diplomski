Object shared = new Object();
startThread2(shared);
synchronized (shared) {
  while (taskNotDone())
    shared.wait();
}