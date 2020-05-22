@Constraint(validatedBy={UniqueKeyValidator.class})
@Target({ElementType.TYPE})
@Retention(RUNTIME)
public @interface UniqueKey {

    String[] columnNames();

    String message() default "{UniqueKey.message}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    @Target({ ElementType.TYPE })
    @Retention(RUNTIME)
    @Documented
    @interface List {
        UniqueKey[] value();
    }
}