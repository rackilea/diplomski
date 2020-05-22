@Configuration
protected static class CustomRepositoryRestMvcConfiguration extends RepositoryRestMvcConfiguration {

    @Autowired
    private Validator validator;

    @Override
    protected void configureValidatingRepositoryEventListener(ValidatingRepositoryEventListener validatingListener) {
        validatingListener.addValidator("beforeCreate", validator);
        validatingListener.addValidator("beforeSave", validator);
    }
}