public interface MessageReceivedListener {
    void onMessageReceived(Object sender, MessageReceivedEventArgs e);
}

private MessageReceivedListener messageReceivedListener;

public void setMessageReceivedListener(MessageReceivedListener listener) {
    this.messageReceivedListener = listener;
}

protected void onMessageReceived(Socket socket, CommandType commandType, MemoryStream message) {
    if (this.messageReceivedListener != null) {
        this.messageReceivedListener.onMessageReceived(this,
           new MessageReceivedEventArgs(socket, commandType, message));
    }
}