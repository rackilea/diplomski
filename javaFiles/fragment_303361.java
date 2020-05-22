Validator v = Validation.byDefaultProvider().configure()
        .constraintValidatorFactory(new MyConstraintValidatorFactory())
        .buildValidatorFactory()
        .getValidator();

class MyConstraintValidatorFactory implements ConstraintValidatorFactory {

    public <T extends ConstraintValidator<?, ?>> T getInstance(final Class<T> arg0) {
        //do your stuff to set dependencies
        ...
    }

    public void releaseInstance(final ConstraintValidator<?, ?> arg0) {
        ...
    }
}