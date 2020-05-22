import com.pasindu.queue.seda.event.Event;
import com.pasindu.queue.seda.thread.pool.ThreadPool;
import com.pasindu.queue.seda.handler.EventHandler;
import com.pasindu.queue.seda.helper.Logger;
import com.pasindu.queue.seda.queue.Queue;

public class Stage extends Thread {

    private Queue inputQueue;
    private Queue outputQueue;


    private int batchSize;

    private ThreadPool threadPool;

    public Stage(Queue inputQueue, Queue outputQueue, int batchSize){
        this.threadPool = new ThreadPool();
        this.batchSize = batchSize;
        this.inputQueue =  inputQueue;
        this.outputQueue = outputQueue;
    }

    @Override
    public void run(){
        while(true){

            Event event = null;

            try{
                event = inputQueue.dequeue();
                Logger.log(this.toString(), "Dequeued "+event.toString()+" from "+inputQueue.toString());
            }catch (InterruptedException ex){

            }

            if(event != null) {
                EventHandler handler = event.getHandler();
                handler.setOutQueue(outputQueue);
                handler.setName(this.getName()+"'s Event Handler");
                threadPool.submit(handler);
                Logger.log(this.toString(), "Enqueued " + event.toString() + " to " + outputQueue);
            }else{
                try {
                    Thread.sleep(10);
                }catch(InterruptedException ex){

                }
            }

        }
    }


}