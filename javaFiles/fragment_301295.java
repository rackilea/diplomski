Persistence.createEntityManagerFactory(getEMFactoryParameter());
    ...

    public String getEMFactoryParameter() {

      if(environment == ApplicationEnvironment.DEVELOPMENT) {
        return "mydb_dev";
      } else if(environment == ApplicationEnvironment.TEST) {
        return "mydb_test";
      } else {
        return "mydb_prod";
      }
    }