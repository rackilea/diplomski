import java.util.EventListener;

@FunctionalInterface
public interface ConnectionReceivedListener extends EventListener
{
    public void onConnectionReceived(ConnectionReceivedEvent event);
}