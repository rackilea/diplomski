@Provider
public class AuthenticationDynamicFeature implements DynamicFeature {

    @Override
    public void configure(ResourceInfo resourceInfo, FeatureContext featureContext) {
        featureContext.register(new AuthenticationFilter(resourceInfo));
    }
}