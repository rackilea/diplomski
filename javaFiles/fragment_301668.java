validatorSuite = Configuration.getValidatorSuite(SAML_VALIDATOR_SUITE_ID);
    // deregister default subject validator and register customized validator (including EncryptedID).
    List<Validator> validators = validatorSuite.getValidators(Subject.DEFAULT_ELEMENT_NAME);
    if (validators != null && validators.size() > 0) {
        validatorSuite.deregisterValidator(Subject.DEFAULT_ELEMENT_NAME, validators.get(0));
    }
    validatorSuite.registerValidator(Subject.DEFAULT_ELEMENT_NAME, new SubjectSchemaValidator());