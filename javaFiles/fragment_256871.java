public class YourCondition implements Condition {

    @Override 
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        return "concret".equals(context.getEnvironment().getProperty("your.property"));
    }

}