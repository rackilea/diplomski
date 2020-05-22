ValidatorFactory validatorFactory = Validation
            .byDefaultProvider()
            .configure()
            .ignoreXmlConfiguration()
            .buildValidatorFactory();

    Validator validator = validatorFactory.getValidator();