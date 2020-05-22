private final class Repository {

  private Repository() {}

  private static final JdbcTemplate TEMPLATE;

  private static PlatformTransactionManager manager = ApplicationBeansProvider.getBean("transactionManager");


  static {
    DataSource source =
      ( ( JpaTransactionManager ) manager ).getDataSource();

    TEMPLATE = new JdbcTemplate( source );

  }

  public Map<String, Object> fetchData() {
    return TEMPLATE1.queryForList( "..." ); // TODO: something
  }

}