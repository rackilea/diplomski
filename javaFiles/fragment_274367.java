/**
 * An event that is emitted when a consumer is not responding to
 * the poll; a possible indication that the broker is down.
 *
 * @author Gary Russell
 * @since 1.3.1
 *
 */
@SuppressWarnings("serial")
public class NonResponsiveConsumerEvent extends KafkaEvent {