@Configuration
@Lazy
class SpringValidatorConfiguration {

    @Bean
    @Lazy
    public HibernatePropertiesCustomizer hibernatePropertiesCustomizer(final Validator validator) {
        return new HibernatePropertiesCustomizer() {

            @Override
            public void customize(Map<String, Object> hibernateProperties) {
                hibernateProperties.put("javax.persistence.validation.factory", validator);
            }
        };
    }
}