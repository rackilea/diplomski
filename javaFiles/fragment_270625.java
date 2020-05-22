@Configuration
class MyConfig {

  @Bean
  CassandraTemplate cassandraTemplate(CassandraConverter converter) {
    SessionFactory factory = …;
    return new CassandraTemplate(factory, converter);
  }
}