static class Initializer implements ApplicationContextInitializer<ConfigurableApplicationContext> {

    @Override
    public void initialize(ConfigurableApplicationContext configurableApplicationContext) {
      String url = "jdbc:mysql://" + DB.getContainerIpAddress() + ":" + DB.getMappedPort(3306) + "/my_db";

      TestPropertyValues
          .of("datasources.schema1.url=" + url)
          .applyTo(configurableApplicationContext.getEnvironment());
    }
  }