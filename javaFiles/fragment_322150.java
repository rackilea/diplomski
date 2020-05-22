@Bean
public FooRoute fooRoute(){
  return new FooRoute();
}

@Override
public List<RouteBuilder> routes() {
  final List<RouteBuilder> routes = new ArrayList<>();
  routes.add(fooRoute());
  return routes;
}