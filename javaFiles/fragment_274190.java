HibernateValidatorConfiguration conf = (HibernateValidatorConfiguration) Validation.byDefaultProvider().configure();
conf.addConstraintDefinitionContributor((constraintDefinitionContributionBuilder) -> {
    constraintDefinitionContributionBuilder.constraint(Future.class)
            .validatedBy(MyCustomFutureConstraintValidator.class)
            .includeExistingValidators(true);
});
Validator validator = conf.buildValidatorFactory().getValidator();