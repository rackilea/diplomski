GCTest test;
// Without the null assignment
test = create(0);
test = create(1);
test = null;
System.gc();

try {Thread.sleep(10);} catch (Exception e){}
System.out.println();

// With the null assignment
test = create(2);
test = null;
test = create(3);
test = null;
System.gc();