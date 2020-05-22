/**
 * @return The maximum number of messages to receive for each poll.
 * Can be specified as 'property placeholder', e.g. {@code ${poller.maxMessagesPerPoll}}.
 * Defaults to -1 (infinity) for polling consumers and 1 for polling inbound channel adapters.
 */
String maxMessagesPerPoll() default "";