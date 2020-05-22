import com.pasindu.queue.seda.event.Event;
import com.pasindu.queue.seda.handler.EventHandler;


public class HttpResponseEvent implements Event {

    private String requestId;

    public HttpResponseEvent(String requestId){
        this.setRequestId(requestId);
    }

    public EventHandler getHandler(){
        return null;
    }


    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }


}