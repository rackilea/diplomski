public class MyLongRunningThread extends Thread {
    @Override
    public void run() {
        while(true) {
            try {
                // Do stuff
             } catch(InterruptedException e) {
                 // The thread was interrupted, which means someone wants us to stop
                 System.out.println("Interrupted; exiting");
                 return;
             } catch(RuntimeException e) {
                 e.printStackTrace();
             }
        }
    }
}