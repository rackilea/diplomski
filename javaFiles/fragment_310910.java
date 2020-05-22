public @interface Capacity {

    String message() default "Capacity not in valid Range";

    // Required by validation runtime
    Class<?>[] groups() default { };
    Class<? extends Payload>[] payload() default { };

    int min();
    int max();
}