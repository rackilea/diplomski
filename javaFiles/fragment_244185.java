private String killQuery(long id) {
    String killCommand="KILL " + id;
    queryManager.getTransaction().begin();
    Query query=queryManager.createNativeQuery(killCommand);
    query.executeUpdate();
    queryManager.getTransaction().commit();
    return "OK";
}