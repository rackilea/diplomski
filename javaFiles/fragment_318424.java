@Bean
  public static PropertySourcesPlaceholderConfigurer properties(Environment environment) throws IOException {
    AbstractEnvironment standardEnvironment = ((AbstractEnvironment) environment);
    MutablePropertySources propertySources = standardEnvironment.getPropertySources();
    propertySources.addLast(new DurationValuePropertySource());
  }