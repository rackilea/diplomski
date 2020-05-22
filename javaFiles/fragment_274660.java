/**
 * This is only to be used internally to provide the MQTT id of a message
 * received from the server.  Has no effect when publishing messages.
 * @param messageId
 */
public void setId(int messageId) {
    this.messageId = messageId;
}