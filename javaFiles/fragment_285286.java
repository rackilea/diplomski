@ApiMethod(name = "getClient")
public Client getClient(@Named("id") Long id) {
    EntityManager mgr = getEntityManager();
    Client client = mgr.find(Client.class, id);
    if (client != null)
        client.getAssessment();  // Forces it to load your objects
    mgr.close();
    return client;
}