import com.pasindu.queue.seda.event.Event;
import com.pasindu.queue.seda.handler.EventHandler;
import handler.ByteArrayEventHandler;

import java.nio.ByteBuffer;

public class ByteArrayEvent implements Event {

    private EventHandler handler;
    private ByteBuffer buffer;
    private String requestId;
    private byte[] data ;
    private int numRead;

    public ByteArrayEvent(ByteBuffer byteBuffer, String requestId, byte[] data, int numRead ){
        this.setBuffer(byteBuffer);
        this.setRequestId(requestId);
        this.setData(data);
        this.setHandler(new ByteArrayEventHandler(this));
        this.numRead = numRead;
    }

    public EventHandler getHandler(){
        return this.handler;
    }


    public ByteBuffer getBuffer() {
        return buffer;
    }

    public void setBuffer(ByteBuffer buffer) {
        this.buffer = buffer;
    }

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public void setHandler(EventHandler handler) {
        this.handler = handler;
    }


    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }

    public int getNumRead() {
        return numRead;
    }

    public void setNumRead(int numRead) {
        this.numRead = numRead;
    }
}