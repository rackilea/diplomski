Example5 ex1 = new Example5(); // a = 1
new Thread(ex1).start();  // start a new thread that will execute independently from current thread

Example5 ex2 = new Example5(); // a = 2 (a is static hence shared)
new Thread (ex2).start(); // start a new thread again

// thread1 and thread2 finish (the order is not determined - could be 
// thread2 first, then thread1)
// prints: 2 2
// If Thread1 finishes before the second "new Example5()" completes
// prints: 1 2