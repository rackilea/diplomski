private final ReentrantLock lock = new ReentrantLock(true); //fair lock
   // ...

   public void m() {
     lock.lock();  // block until condition holds
     try {
       // ... method body
     } finally {
       lock.unlock()
     }
   }