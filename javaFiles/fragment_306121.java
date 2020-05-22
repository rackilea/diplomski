static int counter = 0;
 ...
 // thread T2
 // 3 operations: get, increment, store
 // this thread might be interrupted in the middle causing a ++ to be lost
 counter++;
 ...
 // thread T3
 // 3 operations: get, increment, store
 // this thread might be interrupted in the middle causing a ++ to be lost
 counter++;
 ...
 // later on, even if T2 and T3 have completed, you may see the counter as 1 or 2
 System.out.println("counter = " + counter);