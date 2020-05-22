import com.pasindu.queue.seda.event.Event;
import com.pasindu.queue.seda.handler.EventHandler;
import handler.BufferEventHandler;

import java.nio.ByteBuffer;

public class BufferEvent implements Event {

    private EventHandler handler;
    private ByteBuffer buffer;
    private String requestId;
    private int numRead;

    public BufferEvent(ByteBuffer byteBuffer, String requestId, int numRead){
        this.setBuffer(byteBuffer);
        this.setRequestId(requestId);
        this.setNumRead(numRead);
        this.setHandler(new BufferEventHandler(this));
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

    public int getNumRead() {
        return numRead;
    }

    public void setNumRead(int numRead) {
        this.numRead = numRead;
    }

    public void setHandler(EventHandler handler) {
        this.handler = handler;
    }


}