@Retention(RetentionPolicy.RUNTIME)
public @interface RequiredKeys {
    requireKey[] value();
}

@Repeatable(RequiredKeys)
public @interface RequiredKey {
    String value();
}