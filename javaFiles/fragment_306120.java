static Integer sharedValue = 1;
 ...
 // thread T1 changes the shared value
 sharedValue = 2;
 ...
 // thread T2 reads the shared value later
 // it is unknown whether this will print 1 or 2
 System.out.println("shared = " + sharedValue);