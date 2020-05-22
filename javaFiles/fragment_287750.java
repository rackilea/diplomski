import com.pasindu.queue.seda.handler.EventHandler;

public interface Event {

    public EventHandler getHandler();

}