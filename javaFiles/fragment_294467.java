object MyClass {
  private val LOCK = new ReentrantLock
}
class MyClass {
  def calculate(...): double = {
      val gotLock = LOCK.tryLock(20, TimeUnit.Seconds)
      try {
          ...
      } finally {
        if (gotLock) {
          LOCK.unlock()
        }
      }
  }
}