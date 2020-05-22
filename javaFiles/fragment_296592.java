/**
 * Set whether or not the container should commit offsets (ack messages) where the
 * listener throws exceptions. This works in conjunction with {@link #ackMode} and is
 * effective only when the kafka property {@code enable.auto.commit} is {@code false};
 * it is not applicable to manual ack modes. When this property is set to {@code true}
 * (the default), all messages handled will have their offset committed. When set to
 * {@code false}, offsets will be committed only for successfully handled messages.
 * Manual acks will be always be applied. Bear in mind that, if the next message is
 * successfully handled, its offset will be committed, effectively committing the
 * offset of the failed message anyway, so this option has limited applicability.
 * Perhaps useful for a component that starts throwing exceptions consistently;
 * allowing it to resume when restarted from the last successfully processed message.
 * @param ackOnError whether the container should acknowledge messages that throw
 * exceptions.
 */
public void setAckOnError(boolean ackOnError) {
    this.ackOnError = ackOnError;
}