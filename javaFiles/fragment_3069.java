@Bean
   public Docket postsApi() {
      return new Docket(DocumentationType.SWAGGER_2)//.groupName("public-api")
              .groupName("")
                .directModelSubstitute(LocalDateTime.class, String.class)
               .directModelSubstitute(LocalDate.class, String.class)
               .directModelSubstitute(LocalTime.class, String.class)
               .directModelSubstitute(ZonedDateTime.class, String.class)
            .apiInfo(apiInfo())
            .select()
            .apis(RequestHandlerSelectors.withClassAnnotation(RestController.class))

            .paths(PathSelectors.any())
            .paths(postPaths()).build().useDefaultResponseMessages(false)
                .globalResponseMessage(RequestMethod.GET, getCustomizedResponseMessages());
   }