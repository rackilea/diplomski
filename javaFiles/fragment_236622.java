public interface IMessageListener<T extends IMessage> {

    public void onMessage(T message);
}

public interface XMLMessageListener<T extends XMLMessage> extends IMessageListener<T> {
}

public interface XMLStatusMessageListener extends XMLMessageListener<XMLStatusMessage> {
}