Module m1 = new Module() {

  @Override
  public void configure(Binder binder) {
    binder.bindMap(Constants.PROPERTIES_MAP)
       .put(Constants.JDBC_DRIVER_PROPERTY, "com.my.Driver")
       .put(Constants.JDBC_URL_PROPERTY, "jdbc://db1_url")
       .put(Constants.JDBC_USERNAME_PROPERTY, "db1login")
       .put(Constants.JDBC_PASSWORD_PROPERTY, "db1password");
  }
};

ServerRuntime r1 = new ServerRuntime("cayenne-project.xml", m1);