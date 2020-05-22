import com.pasindu.queue.seda.handler.EventHandler;
import com.pasindu.queue.seda.helper.Logger;
import com.pasindu.queue.seda.queue.Queue;
import event.BufferEvent;
import event.ByteArrayEvent;

import java.nio.ByteBuffer;

public class BufferEventHandler implements EventHandler {

    private BufferEvent event;
    private Queue outQueue;
    private String name;

    public BufferEventHandler(BufferEvent event){
        this.event = event;
    }

    public String getName(){
        return this.name;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setOutQueue(Queue queue){

        this.outQueue = queue;
    }

    public void  onEvent() throws InterruptedException{

        ByteBuffer buffer = this.event.getBuffer();
        String requestId = this.event.getRequestId();
        int numRead = this.event.getNumRead();


        Logger.log(this.toString(), "Recieved "+event.toString());

        buffer.flip();
        byte[] data = new byte[numRead];
        System.arraycopy(buffer.array(), 0, data, 0, numRead);

        ByteArrayEvent byteEvent = new ByteArrayEvent(buffer, requestId, data, numRead );


        Logger.log(this.toString(), "Set new object to "+byteEvent.toString());

        outQueue.enqueu(byteEvent);

        Logger.log(this.toString(), byteEvent.toString()+" added to "+outQueue.toString());
    }

    public void run(){
        Logger.log(this.toString(), "Running "+ this.toString()+" for "+event.toString());

        try{
            this.onEvent();
        }catch (InterruptedException ex){

        }
    }



}