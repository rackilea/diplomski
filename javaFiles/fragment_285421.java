public abstract class ProfileCondition extends SpringBootCondition {
    @Override
    public ConditionOutcome getMatchOutcome(ConditionContext conditionContext, AnnotatedTypeMetadata annotatedTypeMetadata) {
        if (matchProfiles(conditionContext.getEnvironment())) {
            return ConditionOutcome.match("A local profile has been found.");
        }
        return ConditionOutcome.noMatch("No local profiles found.");
    }

    protected abstract boolean matchProfiles(final Environment environment);
}

public class DevProfileCondition extends ProfileCondition {
   private boolean matchProfiles(final Environment environment) {    
        return Arrays.stream(environment.getActiveProfiles()).anyMatch(prof -> {
            return prof.equals("dev") || prof.equals("prof1")) || prof.equals("prof2"));
        });
    }
}

public class ProdProfileCondition extends ProfileCondition {
   private boolean matchProfiles(final Environment environment) {    
        return Arrays.stream(environment.getActiveProfiles()).anyMatch(prof -> {
            return !prof.equals("dev") && !prof.equals("prof1")) && !prof.equals("prof2"));
        });
    }
}