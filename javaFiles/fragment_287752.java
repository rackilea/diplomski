import com.pasindu.queue.seda.event.Event;
import com.pasindu.queue.seda.helper.Logger;

import java.util.concurrent.ArrayBlockingQueue;

public class Queue {

    private int capacity;

    private ArrayBlockingQueue<Event> queue;
    private String name;

    public Queue (int capacity, String name){
        this.setCapacity(capacity);
        this.name = name;
        setQueue(new ArrayBlockingQueue<Event>(capacity));
    }

    public String getName(){return this.name;}

    public void enqueu(Event event) throws InterruptedException{
        Logger.log(this.toString(), "Enqueing attempt for "+event.toString()+" to "+this.toString());
        getQueue().put(event); // if queue is full the calling thread has to wait till this sucess (in our case the main thread or one of event handler threads in the executor pool)
    }

    public Event dequeue() throws InterruptedException{
        Logger.log(this.toString(), "Dequeing attempt "+" from "+this.toString());
        return this.getQueue().take(); // if queue is empty then the calling thread (stage thread) has to wait till the event becomes available
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public ArrayBlockingQueue<Event> getQueue() {
        return queue;
    }

    public void setQueue(ArrayBlockingQueue<Event> queue) {
        this.queue = queue;
    }

    public int getNumElements(){
        return queue.size();
    }
}