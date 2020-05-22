import com.pasindu.queue.seda.helper.Logger;

public class ThreadMonitor extends Thread{

    private Thread [] threads;

    public ThreadMonitor(Thread [] threads){
        this.threads= threads;
    }

    @Override
    public void run(){
        while(true){
            try{
                Thread.sleep(11000);
            }catch(InterruptedException ex){

            }

            for(Thread thread: threads){
                Logger.log(this.toString(), thread.getName()+" is "+thread.getState());
            }
        }
    }

}