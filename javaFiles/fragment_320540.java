@Bean
  public OpenAPI customOpenAPI() {
    return new OpenAPI()
            .components(new Components().addSecuritySchemes("bearer-jwt",
             new SecurityScheme().type(SecurityScheme.Type.HTTP).scheme("bearer").bearerFormat("JWT")
            .in(SecurityScheme.In.HEADER).name("Authorization")))
            .info(new Info().title("App API").version("snapshot"))
            .addSecurityItem(
                    new SecurityRequirement().addList("bearer-jwt", Arrays.asList("read", "write")));
  }