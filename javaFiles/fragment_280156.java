@Configuration
@Conditional(MyConditionalConfiguration.Condition.class)
@ImportResource("/com/example/context-fragment.xml")
public class MyConditionalConfiguration {
    static class Condition implements ConfigurationCondition {
         @Override
         public ConfigurationPhase getConfigurationPhase() {
             return ConfigurationPhase.PARSE_CONFIGURATION;
         }
         @Override
         public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
             // only load context-fragment.xml if the system property is defined
             return System.getProperty("com.example.context-fragment") != null;
         }
    }
}