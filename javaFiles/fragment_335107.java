Semaphore s1 = new Semaphore(0);
Semaphore s2 = new Semaphore(0);
Semaphore s3 = new Semaphore(0);
Semaphore s4 = new Semaphore(0);
new CounterThread("Thread1", s1, s2).start();
new CounterThread("Thread2", s2, s3).start();
new CounterThread("Thread3", s3, s4).start();
new CounterThread("Thread4", s4, s1).start();
s1.release(); // Start the counting