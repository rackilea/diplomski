@Produces
  public MyInterface createService(
    @Any Instance<MyInterface> instance, InjectionPoint ip){
    // you will need to determine if @Admin or @User should be used ... I dont know your user handling, so this is custom coding.
    return instance.select(annotation).get();
  }