@Component
class MySessionRefresh {

  private final Session session;
  private final Environment environment;

  // omitted constructors for brevity

  @EventListener
  @Order(Ordered.LOWEST_PRECEDENCE)
  public void handle(RefreshScopeRefreshedEvent event) {

    String keyspace = environment.getProperty("spring.data.cassandra.keyspace-name");
    session.execute("USE " + keyspace + ";");
  }
}