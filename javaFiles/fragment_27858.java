@Bean
public Docket demoApi() {
    return new Docket(DocumentationType.SWAGGER_2)//<3>
            .select()//<4>
            .apis(RequestHandlerSelectors.any())//<5>
            .paths(Predicates.not(PathSelectors.regex("/error.*")))//<6>, regex must be in double quotes.
            .build()
}