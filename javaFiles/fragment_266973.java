public void doSomethingQuasiAtomic() {
   synchronized (exampleLock) {
      // Your code block goes here. 
      // Only one thread will ever be in this block at a time.
      ...
   }
}