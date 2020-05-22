Resource[] resources = new PathMatchingResourcePatternResolver()
    .getResources("classpath*:META-INF/spring-configuration-metadata.json");
ConfigurationMetadataRepositoryJsonBuilder builder = ConfigurationMetadataRepositoryJsonBuilder.create();
for (Resource resource : resources) {
    try (InputStream in = resource.getInputStream()) {
        builder.withJsonResource(in);
    }
}
ConfigurationMetadataRepository repository = builder.build();