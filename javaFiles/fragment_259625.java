public class MyClientDetailsService implements ClientDetailsService {

  @Override
  @Cacheable("ClientDetails")
  public ClientDetails loadClientByClientId(String clientId) {
    log.info("Got called!");
    ...
  }
}