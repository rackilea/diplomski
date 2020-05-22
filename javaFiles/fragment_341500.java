//NOTE: The following code is only an outline to highlight relevant code snippets
@Bean 
public SwaggerSpringMvcPlugin plugin() {
    new SwaggerSpringMvcPlugin(...)
        //more config
        .pathProvider(yourPathProvider());
}

private SwaggerPathProvider yourPathProvider() {
    SwaggerPathProvider pathProvider = new RelativeSwaggerPathProvider(...);
    pathProvider.setApiResourcePrefix("/rest"); //<-- NOTE: this is what you need
    return pathProvider;
}