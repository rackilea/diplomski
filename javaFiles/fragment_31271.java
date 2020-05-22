public abstract class Queue implements Runnable {
private final LinkedBlockingQueue<Message> queue;

public Queue() {
    this.queue = new LinkedBlockingQueue<Message>();
}

/**
 * Adds a message to the queue.
 * @param message
 */
public void add(final Message message) {
    try {
        queue.put(message);
    } catch (final InterruptedException e) {
        e.printStackTrace();
    }
}

/**
 * Waits for new messages
 */
@Override
public void run() {
    while(true) {
        try {
            final Message message = queue.take();
            processMessage(message);
        } catch (final InterruptedException e) {
            e.printStackTrace();
        }
    }
}

/**
* Processes the new message
*/
protected abstract void processMessage(Message message);