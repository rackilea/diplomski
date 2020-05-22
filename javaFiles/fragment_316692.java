Thread instance1 = new MyThread(0); //created one instance
Thread instance2 = new MyThread(1); //created another instance

//we have two different instances now
// let's see if that is true, or not:
System.out.println("The two threads are " + (instance1==instance2?"the same":"different"));

instance1.start(); //start first thread instance
instance2.start(); //start second instance 

//we just started the two different threads