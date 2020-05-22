public class MyThread extends Thread {
    private ThreadFinishListener listener; 

    public MyThread(ThreadFinishListener listener){
       this.listener = listener;
    }

    public void run(){
        //Do some stuff
        finish();
    }

    public void finish() {
        // This will invoke the function call in your activity
        listener.onFinish();
    }
}