// This dynamic binding provider registers GZIPWriterInterceptor
// only for HelloWorldResource and methods that contain
// "VeryLongString" in their name. It will be executed during
// application initialization phase.
public class CompressionDynamicBinding implements DynamicFeature {

    @Override
    public void configure(ResourceInfo resourceInfo, FeatureContext context) {
        if (HelloWorldResource.class.equals(resourceInfo.getResourceClass())
                && resourceInfo.getResourceMethod().getName().contains("VeryLongString")) {
            context.register(GZIPWriterInterceptor.class);
        }
    }
}