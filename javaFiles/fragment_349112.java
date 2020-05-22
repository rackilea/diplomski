int timeoutTime = ...
Runnable networkingStuff = ... // put the networking in here
Thread thread =new Thread(networkingStuff);
thread.start();
try {
    thread.join(timeoutTime);
    if(thread.isAlive()) {
        thread.interrupt();
    }
} catch (InterruptedException e) {
    // catch here the interruption
 }