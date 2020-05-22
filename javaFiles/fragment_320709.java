c2.start();  // Start a thread in the background
c1.start();  // Start a 2nd thread in the background

try {
    c2.join();  // Wait until the c2 thread completes
    c1.join();  // Wait until the c1 thread completes
} catch (InterruptedException e) {
    // LOG AN ERROR HERE
}

// print out the final balance
System.out.println(account.getBalance());