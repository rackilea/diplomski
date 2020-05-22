import com.pasindu.queue.seda.handler.EventHandler;
import com.pasindu.queue.seda.helper.Logger;
import com.pasindu.queue.seda.queue.Queue;
import event.ByteArrayEvent;
import event.HttpRequestEvent;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;

public class ByteArrayEventHandler implements EventHandler {

    private ByteArrayEvent event;
    private Queue outQueue;
    private String name;

    public String getName(){
        return this.name;
    }

    public void setName(String name){
        this.name = name;
    }

    public ByteArrayEventHandler(ByteArrayEvent event){
        this.event = event;
    }

    public void  onEvent() throws InterruptedException{

        Logger.log(this.toString(), "Recieved event "+event.toString());

        ByteBuffer buffer = this.event.getBuffer();
        String requestId = this.event.getRequestId();
        byte[] data = this.event.getData();
        int numRead = this.event.getNumRead();

        String request = null;
        try {
            request = new String(data, "US-ASCII");
        }catch (UnsupportedEncodingException ex){

        }

        request = request.split("\n")[0].trim();

        HttpRequestEvent httpRequestEvent = new HttpRequestEvent(buffer, requestId, request);

        outQueue.enqueu(httpRequestEvent);

        Logger.log(this.toString(), "Enqueued "+httpRequestEvent.toString() +" to "+outQueue.toString());

    }

    public void setOutQueue(Queue queueu){
        this.outQueue = queueu;
    }


    public void run(){
        Logger.log(this.toString(), "Running "+ this.toString()+" for "+event.toString());

        try{
            this.onEvent();
        }catch (InterruptedException ex){

        }
    }


}