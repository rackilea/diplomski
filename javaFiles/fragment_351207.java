long readMethodStartTime = System.nanoTime();
readMethod();
long readMethodEndTime = System.nanoTime();

long readMethodDuration = readMethodEndTime - readMethodStartTime ;
System.out.println("Time taken for readMethod to execute: " + readMethodDuration);