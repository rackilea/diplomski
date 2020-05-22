protected final ReentrantLock lock = new ReentrantLock(true); // fair scheduling

public void functionA() {
  lock.lock();
  try {
    controller.functionA();
  } finally {
    lock.unlock();
  }
}

public void functionB() {
  lock.lock();
  try {
    controller.functionB();
  } finally {
    lock.unlock();
  }
}