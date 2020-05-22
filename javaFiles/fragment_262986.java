@Bean
public Docket docket() {
    return new Docket(DocumentationType.SWAGGER_2)
                .groupName("name")
                .directModelSubstitute(LocalDateTime.class, String.class)
                .directModelSubstitute(LocalDate.class, String.class)
                .directModelSubstitute(LocalTime.class, String.class)
                .directModelSubstitute(ZonedDateTime.class, String.class)
                .apiInfo(apiInfo())
                .select()
                .paths(paths())
                .build();
}