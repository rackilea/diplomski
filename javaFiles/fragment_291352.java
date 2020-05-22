public class MyConditionalProd implements ConfigurationCondition{

    @Override
    public ConfigurationPhase getConfigurationPhase() {
        return ConfigurationPhase.PARSE_CONFIGURATION;
    }

    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        String property = context.getEnvironment().getProperty("someProperty");
        if("prod".equals(property)) {
            return true;
        }else{
            return false;
        }
    }

}