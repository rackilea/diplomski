@Bean
public ResourceProcessor<Resource<Invoice>> processor() {
    return new ResourceProcessor<Resource<Invoice>>() {
        @Override
        public Resource<Invoice> process(Resource<Invoice> resource) {
            resource.add(entityLinks.linkToSingleResource(Invoice.class, 1));
            return resource;
        }
    };
}