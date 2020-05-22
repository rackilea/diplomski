@Override
public void configureClient(ClientConfig config) {
    config.register(new MoxyJsonConfig().setFormattedOutput(true)
            .property(MarshallerProperties.BEAN_VALIDATION_MODE, BeanValidationMode.NONE)
            .resolver());
}