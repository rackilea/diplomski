import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root
public class QueueEntries {

    @Element
    private Queue queue;

    public Queue getQueue() {
        return queue;
    }
}