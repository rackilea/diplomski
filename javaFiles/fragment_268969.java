public class StoreInJCR {
  public void store(Quote quote) throws LoginException, RepositoryException {
        SlingRepository slingRepository = ResourceResolverDiscoveryService.getInstance().getSlingRepositoryFactory();

        // GOT IT!!! Mission Accomplished
        Session session = slingRepository.loginAdministrative(null);
        Node root = session.getRootNode();
        // Further code
        .
        .
  }
}