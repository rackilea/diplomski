@Component
@Primary
@EnableAutoConfiguration
public class SwaggerAggregatorController implements SwaggerResourcesProvider {
    @Override
    public List<SwaggerResource> get() {
        List<SwaggerResource> resources= new ArrayList<>();
        SwaggerResource swaggerResource = new SwaggerResource();
        swaggerResource.setName("cust-service");
        swaggerResource.setLocation("/cust/v2/api-docs");
        swaggerResource.setSwaggerVersion("2.0");

        resources.add(swaggerResource);
        return resources;
    }
}