@Configuration
 public DefaultConfig {

      @Bean
      public DataSource dataSource() { ... }

      @Configuration
      @Profile("jndi")
      public static class JndiConfig {

          @Bean
          public DataSource dataSource() { ... // JNDI lookup }
      }

 }