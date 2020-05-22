@Override
  public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
    PageableHandlerMethodArgumentResolver resolver = new PageableHandlerMethodArgumentResolver();
    resolver.setMaxPageSize(10);
    resolver.setOneIndexedParameters(true);
    argumentResolvers.add(resolver);
    super.addArgumentResolvers(argumentResolvers);
  }