import com.pasindu.queue.seda.handler.EventHandler;
import com.pasindu.queue.seda.helper.Logger;
import com.pasindu.queue.seda.queue.Queue;
import event.HttpRequestEvent;
import event.HttpResponseEvent;

import java.nio.ByteBuffer;
import java.util.Dictionary;

public class HttpRequestEventHandler implements EventHandler {

    private HttpRequestEvent event;
    private Queue outQueue;
    private String name;

    public String getName(){
        return this.name;
    }

    public void setName(String name){
        this.name = name;
    }

    public HttpRequestEventHandler(HttpRequestEvent event){
        this.event = event;
    }

    public void setOutQueue(Queue queue){

        this.outQueue = queue;
    }

    private String serverRequest(String request) {
        String response = "";
        if (request.startsWith("GET")) {

        // pass the request and generate response here    

        response = "response";
        return  response;
    }

    public void  onEvent() throws InterruptedException{

        Logger.log(this.toString(),"Recieved "+event.toString());

        ByteBuffer buffer = this.event.getBuffer();
        String requestId = this.event.getRequestId();
        String request = this.event.getRequest();

        Logger.log(this.toString(), "Recieved object inside is "+event);

        String response = serverRequest(request);

        buffer.clear();

        buffer.put(response.getBytes());

        HttpResponseEvent responseEvent= new HttpResponseEvent(requestId);

        Logger.log(this.toString(), "Set new object inside "+event.toString());

        outQueue.enqueu(responseEvent);

        Logger.log(this.toString(), responseEvent.toString()+" added to "+outQueue.toString());
    }

    public void run(){
        Logger.log(this.toString(), "Running "+ this.toString()+" for "+event.toString());

        try{
            this.onEvent();
        }catch (InterruptedException ex){

        }
    }


}