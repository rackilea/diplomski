/**
 * Override the container factory's {@code concurrency} setting for this listener. May
 * be a property placeholder or SpEL expression that evaluates to a {@link Number}, in
 * which case {@link Number#intValue()} is used to obtain the value.
 * <p>SpEL {@code #{...}} and property place holders {@code ${...}} are supported.
 * @return the concurrency.
 * @since 2.2
 */
String concurrency() default "";