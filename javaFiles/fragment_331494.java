public class BindJerseyResources extends ServletModule {

    @Override
    protected void configureServlets() {
        // excplictly bind GuiceContainer before binding Jersey resources
        // otherwise resource won't be available for GuiceContainer
        // when using two-phased injection
        bind(GuiceContainer.class);

        // bind Jersey resources
        PackagesResourceConfig resourceConfig = new PackagesResourceConfig("jersey.resources.package");
        for (Class<?> resource : resourceConfig.getClasses()) {
            bind(resource);
        }

        // Serve resources with Jerseys GuiceContainer
        serve("/*").with(GuiceContainer.class);
    }
}