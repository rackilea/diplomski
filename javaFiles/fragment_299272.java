class SendThread implements Runnable {
    public void run() {
        synchronized (lock){
              // contains code to print to text file
        }
    }
 }

 class ReceiveThread implements Runnable {
    public void run() {
        synchronized (lock){
              // contains code to print to text file
        }
    }
 }