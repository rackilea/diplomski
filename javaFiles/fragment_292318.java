/**
 * Create a PublishSubscribeChannel that will use an {@link Executor}
 * to invoke the handlers. If this is null, each invocation will occur in
 * the message sender's thread.
 *
 * @param executor The executor.
 */
public PublishSubscribeChannel(Executor executor) {