private ReentrantLock lock = new ReentrantLock();

private void pickUp() { // now private
  lock.lock();
  // do something
}

private void putDown() { // now private
  // do something
  lock.unlock();
}

public void use(Consumer<X> consumer) {
  try {
    pickUp();
    consumer.accept(this);  // client gets its hands on the properly initialized resource.
  } finally {
    putDown();
  }
}