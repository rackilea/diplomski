import com.pasindu.queue.seda.helper.Logger;
import com.pasindu.queue.seda.queue.Queue;

public class QueueMonitor extends Thread {
    private Queue[] queues;

    public QueueMonitor(Queue[] queues){
        this.queues= queues;
    }

    @Override
    public void run(){
        while(true){
            try{
                Thread.sleep(9000);
            }catch(InterruptedException ex){

            }

            for(Queue queue: queues){
                Logger.log(this.toString(), queue.getName()+" is "+queue.getNumElements());
            }
        }
    }
}