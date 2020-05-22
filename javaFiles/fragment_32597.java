// Main thread executing...
Thread t = new Thread(
                 new Runnable() {
                     public void run () {
                         //do something
                     }
                  }
    );
t.start(); //Secondary thread starts
// Main thread continues execution
t.join();//Main thread will wait for the secondary to finish
return ...;