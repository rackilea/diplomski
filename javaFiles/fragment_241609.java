Thread t = new Thread(...);
t.start();

// Do half of the job here

t.join(); // Wait for the other half to complete.