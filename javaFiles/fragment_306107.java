public class MyProfileCondition implements Condition {

    @Override
    public boolean matches(final ConditionContext context,
            final AnnotatedTypeMetadata metadata) {
        if (context.getEnvironment() != null) {
            final MultiValueMap<String, Object> attrs = metadata.getAllAnnotationAttributes(Profile.class.getName());
            if (attrs != null) {
                for (final Object value : attrs.get("value")) {
                    final String activeProfiles = context.getEnvironment().getProperty("spring.profiles.active");

                    for (final String profile : (String[]) value) {
                        if (!activeProfiles.contains(profile)) {
                            return false;
                        }
                    }
                }
                return true;
            }
        }
        return true;
    }

}