Validator validator = Validation.byDefaultProvider()
        .configure()
        .messageInterpolator(
                new ResourceBundleMessageInterpolator(
                        new PlatformResourceBundleLocator( "MyMessages" )
                )
        )
        .buildValidatorFactory()
        .getValidator();