@Bean
public Validator validator(final AutowireCapableBeanFactory beanFactory) {

    ValidatorFactory validatorFactory = Validation.byProvider(HibernateValidator.class)
            .configure()
            .constraintValidatorFactory(new SpringConstraintValidatorFactory(beanFactory))
            .buildValidatorFactory();

    return validatorFactory.getValidator();
}