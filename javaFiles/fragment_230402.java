// Insert in your Spring Configuration Class

   @Profile("!production")
   @ConfigurationProperties(prefix = "spring.datasource")
   @Bean
   public DataSource dataSource() {
       return DataSourceBuilder.create().build();
   }

   @Profile("production")
   @ConfigurationProperties(prefix = "spring.datasource")
   @Bean
   public DataSource secondDataSource() {
      return DataSourceBuilder
        .create()
        .url(databaseUrl)   // Override url
        .username(username) // Override username
        .password(password) // Override  password
        .build();
   }