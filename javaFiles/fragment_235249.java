@Provider
public class MaxAgeFeature implements DynamicFeature {
    public void configure(ResourceInfo ri, FeatureContext ctx) {
        if(resourceShouldBeFiltered(ri)){
            ResourceOneFilter filter = new ResourceOneFilter();
            ctx.register(filter);
        }
    }
}