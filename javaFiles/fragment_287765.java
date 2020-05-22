import com.pasindu.queue.seda.helper.Logger;
import com.pasindu.queue.seda.queue.Queue;
import event.HttpResponseEvent;

import java.util.concurrent.ConcurrentHashMap;

public class ResponseMannager extends Thread{

    ConcurrentHashMap concurrentHashMapResponse;
    Queue inQueue;

    public ResponseMannager(ConcurrentHashMap concurrentHashMap, Queue queue){
        this.concurrentHashMapResponse = concurrentHashMap;
        this.inQueue = queue;
    }

    @Override
    public void run() {

        while(true){
            HttpResponseEvent event = null;
            try {
                event = (HttpResponseEvent) inQueue.dequeue();
            }catch(InterruptedException ex){

            }

            if(event!=null) {

                Logger.log(this.toString(), "Dequeued " + event.toString() + " from " + inQueue.toString());
                concurrentHashMapResponse.put(event.getRequestId(), true);
                Logger.log(this.toString(), "Set response availabliity for " + event.getRequestId() + " in " + concurrentHashMapResponse.toString());
            }else{
                try{
                    Thread.sleep(10);
                }catch(InterruptedException ex){

                }
            }
        }

    }
}