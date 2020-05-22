class XYZ implements DynamicFeature {
    @Override
    public void configure(ResourceInfo info, FeatureContext ctx) {
       if (info.getResourceClass().equals(ThirdPartyResource.class) {
           ctx.register(YourWriterImplementation.class);
           // or
           ctx.register(new YourWriterImplementation());
       }
    }
}