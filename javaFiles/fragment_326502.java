@Provider
public class MyDynamicFeature implements DynamicFeature {

    @Override
    public void configure(final ResourceInfo resourceInfo, final FeatureContext context) {
        if ("HelloWorldResource".equals(resourceInfo.getResourceClass().getSimpleName())
                && "getHello".equals(resourceInfo.getResourceMethod().getName())) {
            context.register(MyContainerRequestFilter.class);
        }
    }
}