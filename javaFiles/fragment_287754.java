import com.pasindu.queue.seda.handler.EventHandler;
import com.pasindu.queue.seda.helper.Logger;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPool {

    ExecutorService executorService;

    public ThreadPool (){
        this.executorService = Executors.newFixedThreadPool(4);
    }

    public void submit(EventHandler handler){
        Logger.log(this.toString(),"Calling submit of "+executorService.toString());
        this.executorService.submit(handler);
    }
}