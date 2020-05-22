Thread t1 = new Thread(/*...*/);
Thread t2 = new Thread(/*...*/);

// ...later...

if (Thread.currentThread() == t1) {
    // It's t1
}