@Bean
public ViewResolver contentNegotiatingViewResolver(ContentNegotiationManager manager){
  ContentNegotiatingViewResolver resolver = newContentNegotiatingViewResolver();
  resolver.setContentNegotiationManager(manager);
  List<ViewResolver> resolvers = new ArrayList<>();
  ViewResolver aViewResolver = getJsonViewResolver();
  resolvers.add(aViewResolver);
  resolver.setViewResolvers(resolvers);
  return resolver;
}