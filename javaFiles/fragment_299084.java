@Target({TYPE})
@Retention(RUNTIME)
@Constraint(validatedBy={
        MyFirstEntityValidator.class, MySecondEntityValidator.class,
        MyThirdEntityValidator.class, EtCetera.class})
public @interface MyDomainModelValid {
    String message() default "entity.notValid";
    Class<?>[] groups() default { };
    Class<? extends Payload>[] payload() default {};
}