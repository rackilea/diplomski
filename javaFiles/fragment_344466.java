ChefApi api = ctx.unwrapApi(ChefApi.class);
if (api.getEnvironment("environment-name") == null) {
    Environment env = Environment.builder()
        .name("environment-name")
        .description("Some description")
        .build();
    api.createEnvironment(env);
}