class Module extends AbstractModule {

  Properties properties;

  Module(Properties properties) {
    this.properties = properties;
  }

  @Override
  protected void configure() {
    for (Entry<Object, Object> entry: properties.entrySet()) {
      try {
        Class<?> abstractClass = Class.forName((String)entry.getKey());
        Class implementation = Class.forName((String)entry.getValue());
        bind(abstractClass).to(implementation);
      } catch (ClassNotFoundException e) {
        //Handle e
      }
    }
  }
}