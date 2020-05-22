@Bean
public Service service() throws Exception {
    return new RequestContextExecutor().execute(() -> {
        return Feign.builder()
            .encoder(new JacksonEncoder())
            .decoder(new JacksonDecoder())
            .client(DestinationHelper.getHttpClient(Service.DESTINATION_NAME))
        .target(Service.class, DestinationHelper.getUrl(service.DESTINATION_NAME));
    };
}