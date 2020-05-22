@Configuration
public class ReferenceDataConfig {
    @Bean (name = "myResourceList")
    public List<MyResource> getResourceLst(ResourceA resourceA, ResourceB resourceB, ResourceC resourceC, ResourceD resourceD) {
        return Arrays.asList(
                resourceA
                , resourceB
                , resourceC
                , resourceD
        );
    }