@Primary
   @Bean
   public DataSource getDataSource(
         @Qualifier("first") DataSourceProperties first,
         @Qualifier("second") DataSourceProperties second) {
      final DataSource firstDataSource = first.initializeDataSourceBuilder().build();
//      try {
//         firstDataSource.getConnection();
//         ...
//      } catch (SQLException e) {
//         ...
//      }

//      return firstDataSource or secondDataSource;
   }

   @Primary
   @Bean("first")
   @ConfigurationProperties(prefix = "spring.datasource")
   public DataSourceProperties  getPrimaryStringProvider() {
      final DataSourceProperties dataSourceProperties = new DataSourceProperties();
      return dataSourceProperties;
   }

   @Bean("second")
   @ConfigurationProperties("spring.seconddatasource")
   public DataSourceProperties getSecondaryStringProvider() {
      return new DataSourceProperties();
   }