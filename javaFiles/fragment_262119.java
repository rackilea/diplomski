class JacksonResolver implements ContextResolver<ObjectMapper> {
    private final ObjectMapper mapper = new ObjectMapper();

    public JacksonResolver() {
        // configure mapper
    }

    @Override
    public ObjectMapper resolve(Class<?> cls) {
        return this.mapper;
    }
}

Client client = ClientBuilder.newBuilder()
        .register(JacksonFeature.class)
        .register(new JacksonResolver())
        .build();