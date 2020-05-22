@Component
@ApplicationPath("/api")
public static class JerseyConfig extends ResourceConfig {

    public JerseyConfig() {

        BeanConfig swaggerConfig = new BeanConfig();
        swaggerConfig.setBasePath("/api");
        SwaggerConfigLocator.getInstance().putConfig(SwaggerContextService.CONFIG_ID_DEFAULT, swaggerConfig);

        packages(getClass().getPackage().getName(), ApiListingResource.class.getPackage().getName());
    }

}