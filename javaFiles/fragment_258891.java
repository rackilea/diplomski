// shared was saved at the start of the thread
// do some stuff
markTaskAsDone();
synchronized (shared) {
  shared.notify();
}