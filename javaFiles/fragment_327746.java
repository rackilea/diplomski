public class Message {
    private MessageType type;
    private String text;

    public Message(MessageType type, String text) {
        this.type = type;
        this.text = text;
    }

    public String buildOutput() {
        return type + text;
    }

    // other behaviors here
}