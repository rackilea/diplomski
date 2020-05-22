/**
 * Subclasses can take actions based on the result of the poll; e.g.
 * adjust the {@code trigger}. The message can also be replaced with a new one.
 * @param result the received message.
 * @param source the message source.
 * @return a message to continue to process the result, null to discard whatever the poll returned.
 */
public abstract Message<?> afterReceive(Message<?> result, MessageSource<?> source);