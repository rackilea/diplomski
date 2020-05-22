@Bean
public Docket customerApi() {
return new Docket(DocumentationType.SWAGGER_2)
        .directModelSubstitute(XMLGregorianCalendar.class, String.class)
        .groupName("Customer Application")
        .apiInfo(apiInfo())
        .select()
        .paths(myAppPaths())
        .build();
}