// We should register the feature with our application
public class MyFeature implements Feature {
    @Override
    public boolean configure(FeatureContext context) {
         context.register(MyMessageBodyReader.class);
    }
}