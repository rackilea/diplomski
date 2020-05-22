// Publisher of messages
public interface MessagePublisher {
    void send(Message m, Channel c);
}

// Subscriber of messages
public interface MessageSubscriber {
    void messageReceived(Message r);
}

// Handles registration
public interface MessageSubscriberAware {
    void registerMessageSubscriber(MessageSubscriber s, Channel c);
}

// The "glue" - the concrete implementation
public class MessageDispatcher implements MessagePublisher, MessageSubscriberAware {
    // Impl
}