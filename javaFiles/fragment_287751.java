import com.pasindu.queue.seda.queue.Queue;

public interface EventHandler extends Runnable {

    public void onEvent() throws InterruptedException ;

    public void run();

    public void setOutQueue(Queue queue);

    public String getName();

    public void setName(String name);
}