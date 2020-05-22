public class InternalScheduledAnnotationProcessorDoesntExistCondition implements ConfigurationCondition{

    @Override
    public ConfigurationPhase getConfigurationPhase() {
        return ConfigurationPhase.PARSE_CONFIGURATION;
    }

    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        try{
            context.getRegistry().getBeanDefinition("org.springframework.context.annotation.internalScheduledAnnotationProcessor");
            return false;
        }catch(NoSuchBeanDefinitionException nsde){
            return true;
        }
    }

}