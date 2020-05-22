Environment environment = context.getEnvironment();
hasProperty(environment, "encrypt.key");

private boolean hasProperty(Environment environment, String key) {
            String value = environment.getProperty(key);
            if (value == null) {
                return false;
            }
            return StringUtils.hasText(environment.resolvePlaceholders(value));
        }