private static final DockerComposeContainer postgres = new DockerComposeContainer(new File("src/test/resources/docker-compose-postgres.yml"))
        .withExposedService("postgres-it", 5432);

    /**
     * static block used to workaround shutting down of container after each test class executed
     * TODO: try to remove this static block and use @ClassRule
     */
    static {
        postgres.starting(Description.EMPTY);
    }