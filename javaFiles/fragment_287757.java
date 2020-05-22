import com.pasindu.queue.seda.event.Event;
import com.pasindu.queue.seda.handler.EventHandler;
import handler.HttpRequestEventHandler;

import java.nio.ByteBuffer;

public class HttpRequestEvent implements Event {

    private EventHandler handler;
    private ByteBuffer buffer;
    private String requestId;
    private String request;

    public HttpRequestEvent(ByteBuffer byteBuffer, String requestId, String request){
        this.setBuffer(byteBuffer);
        this.setRequestId(requestId);
        this.setRequest(request);
        this.setHandler(new HttpRequestEventHandler(this));
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

    public String getRequest() {
        return request;
    }

    public void setRequest(String request) {
        this.request = request;
    }
}