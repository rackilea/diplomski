@Persist(PersistenceConstants.FLASH)
private boolean messageSent;


public boolean isMessageSent() {
    return this.messageSent;
}

@OnEvent(EventConstants.SUCCESS)
void onSendMessage() {
    ...
    this.messageSent = true;
}