public class MyFilterDynamicFeature implements DynamicFeature {

    @Override
    public void configure(final ResourceInfo resourceInfo, final FeatureContext configuration) {

        //if the class or the method is annotated, bind a new instance of our filter to this method
        if(resourceInfo.getResourceClass().getAnnotation(MyCustomAnnotation.class)!=null || resourceInfo.getResourceMethod().getAnnotation(MyCustomAnnotation.class)!=null){            
            configuration.register(new MyFilter(resourceInfo.getResourceClass(), resourceInfo.getResourceMethod()));
        }

    }
}