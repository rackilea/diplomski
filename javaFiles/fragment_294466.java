object MyClass {
  private val LOCK = new ReentrantLock
}
class MyClass {
  def calculate(...): double = {
      try{
          LOCK.tryLock(20, TimeUnit.Seconds)
          ...
      }finally{
          LOCK.unlock()
      }
  }
}