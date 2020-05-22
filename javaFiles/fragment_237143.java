long startTime = System.currentTimeMillis();
//the method
long stopTime = System.currentTimeMillis();
long difference = stopTime - startTime;
System.out.println("The task took: " + difference + " milliseconds");
System.out.println("The task took: " + difference/1000 + " seconds");