Environment environment = context.getEnvironment();
RelaxedPropertyResolver propertyResolver = new RelaxedPropertyResolver(environment);
hasProperty(propertyResolver, environment, "encrypt.key");

private boolean hasProperty(RelaxedPropertyResolver propertyResolver, Environment environment, String key) {
        String value = propertyResolver.getProperty(key);
        if (value == null) {
            return false;
        }
        return StringUtils.hasText(environment.resolvePlaceholders(value));
    }