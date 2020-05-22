public class Buyer {
    // ...

    @Null(groups = FooValidation.class)
    @NotNull(groups = NotFooValidation.class)
    protected String billingCountry;
}