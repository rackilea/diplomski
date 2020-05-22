public class ListenerFactory {

    public IListener CreateListener(URI uri, int port) {
        Listener l = new Listener();
        l.MessageReceived += OnMessageReceived;
        // do whatever with l. loop until connection, or use l.Start() for instance
        return l;
    }

    public static event EventHandler<MessageEventArgs> ListenerMessageReceived;

    private static void OnMessageReceived(object sender, MessageEventArgs e) {
        // trigger ListenerMessageReceived
    }
}

public interface IListener {
    event EventHandler<MessageEventArgs> MessageReceived;
    void Send(byte[] data);
}

public class Listener : IListener {
    // implement interface
}