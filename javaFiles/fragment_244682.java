import java.util.EventListener;

public interface SomethingHappenedListener extends EventListener {

    public void somethingHappened(SomethingHappenedEvent e);
}