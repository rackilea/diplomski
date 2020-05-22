@Provider
public class AuthenticationDynamicFeature implements DynamicFeature {

    @Override
    public void configure(ResourceInfo resourceInfo, FeatureContext configuration) {
        if (resourceInfo.getResourceMethod().isAnnotationPresent(Authenticated.class)) {
            configuration.register(new AuthenticationFilter());
            return;
        }

        if (resourceInfo.getResourceClass().isAnnotationPresent(Authenticated.class)) {
            configuration.register(new AuthenticationFilter());
        }
    } 
}