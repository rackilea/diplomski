@Bean
public Docket docket() {
    return new Docket(SWAGGER_2)
        ...
        .tags(
            new Tag("Admin API", "Admin interface to manage users")
        );
}