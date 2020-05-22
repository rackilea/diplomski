class Game implements Runnable {
    @Override
    public void run(){
        // Basically, check for the interruption flag before you do 
        // something that takes time to execute.
        while(!Thread.currentThread.isInterrupted()){
            doSomething();
        }
    }
 }