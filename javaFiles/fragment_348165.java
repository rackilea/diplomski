t1.start();
t2.start();
// t1 and t2 start running in the background but we need to wait for them to finish
t1.join();
t2.join();
Log.i(...);