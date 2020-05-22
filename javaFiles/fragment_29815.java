@Provider
public class MyFilteringFeature implements Feature {

    @Override
    public boolean configure(FeatureContext context) {
        context.property(...);
        context.register(...);
        return true;
    }
}