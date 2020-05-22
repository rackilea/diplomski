public class Friend {

    private final IntegerProperty messageCount = new SimpleIntegerProperty();

    public int getMessageCount() {
        return messageCount.get();
    }

    public void setMessageCount(int value) {
        messageCount.set(value);
    }

    public IntegerProperty messageCountProperty() {
        return messageCount;
    }

    ...

}