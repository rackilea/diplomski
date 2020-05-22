@Bean
public ResourceProcessor<Resource<Invoice>> processor() {
    return (Resource<Invoice> resource) -> {
        resource.add(entityLinks.linkToSingleResource(Invoice.class, 1));
        return resource;
    };
}