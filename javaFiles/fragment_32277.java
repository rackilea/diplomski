/**
 * Identifies a channel that error messages will be sent to if a failure occurs in the
 * gateway's proxy invocation. If no {@code errorChannel} reference is provided, the gateway will
 * propagate {@code Exception}s to the caller. To completely suppress {@code Exception}s, provide a
 * reference to the {@code nullChannel} here.
 * @return the suggested channel name, if any
 */
String errorChannel() default "";