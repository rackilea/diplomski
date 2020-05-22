@Configuration
@EnableWebMvc
@EnableSwagger2


 @Bean
    public Docket api() { 
        return new Docket(DocumentationType.SWAGGER_2)  .apiInfo(apiInfo()).directModelSubstitute(LocalDate.class, String.class).genericModelSubstitutes(ResponseEntity.class)
                .useDefaultResponseMessages(false)
          .select()           
          .apis(RequestHandlerSelectors.any())              
          .paths(PathSelectors.any())                        
          .build();      

    }
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("swagger-ui.html")
          .addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("/webjars/**")
          .addResourceLocations("classpath:/META-INF/resources/webjars/");
    }
    @SuppressWarnings("deprecation")
    private ApiInfo apiInfo() {
        ApiInfo apiInfo = new ApiInfo(
          " REST API",
          "XXX Rest API for XXX authentication and Loan creation.",
          "Mer V1.1",
          "Terms of service",
          "ER",
          "License of API",
          "");
        return apiInfo;
    }