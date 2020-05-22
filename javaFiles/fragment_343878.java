// Choose a, b, c, and d.
int a = 0;
int b = 1;
int c = 2;
int d = 3;

// Set up an array for the intermediate results.
int[] results = new int[2];

// Create two threads writing the intermediate results.
Thread t0 = new Thread(() -> results[0] = a - b);
Thread t1 = new Thread(() -> results[1] = c - d);

// Start both threads.
t0.start();
t1.start();

// Let the main thread wait until both threads are dead.
try {
    t0.join();
    t1.join();
} catch (InterruptedException e) { /* NOP */ }

// Sum up the intermediate results and print it.
System.out.println(results[0] + results[1]);