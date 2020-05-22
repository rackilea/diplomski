boolean flag = true;
Thread secondary = new Thread(new Runnable() {

@Override
public void run() {
    while (flag) {
    // do something
    }
 }
});

secondary.start(); //start the thread
flag = false; // this will force secondary to finish its execution
 try {
   secondary.join(); // wait for secondary to finish
   } catch (InterruptedException e) {
    throw new RuntimeException(e);
}