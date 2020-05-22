final Object lock = new Object(); 

public void lockDemo() {

    System.out.println( Thread.holdsLock(lock) );     // false
    System.out.println( Thread.holdsLock(this) );     // false

    synchronized ( lock ) { 
      System.out.println( Thread.holdsLock(lock) );   // true: locked by object
      System.out.println( Thread.holdsLock(this) );   // false
    }

    doSyncMethod();
}

public synchronized void doSyncMethod() {
    System.out.println( Thread.holdsLock(lock) );  // false
    System.out.println( Thread.holdsLock(this) );  // true: locked by synchronized method
}