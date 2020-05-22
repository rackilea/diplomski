@Provider
public class MyFeature implements Feature {
    @Overrride
    public boolean configure(FeatureContext context) {
        context.register(RolesAllowedDynamicFeature.class);
    }
}