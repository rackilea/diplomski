Validation
    .byProvider(HibernateValidator.class)
    .configure()
    .messageInterpolator(
        new ResourceBundleMessageInterpolator(
            new PlatformResourceBundleLocator("com.mycompany.Messages")))
    .buildValidatorFactory()
    .getValidator();`