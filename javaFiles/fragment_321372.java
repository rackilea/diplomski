@Bean
  public DataSource dataSource() {
    DataSource dataSource = null;
    try {
        Context initialContext = new InitialContext();
        Context environmentContext =   (Context)initialContext.lookup("java:comp/env");
        dataSource = (DataSource) environmentContext.lookup("jdbc/mySql");
    } catch (NamingException e) {
        e.printStackTrace();
    }*/
    return dataSource;
}