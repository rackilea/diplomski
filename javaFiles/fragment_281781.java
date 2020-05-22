@Override
public boolean savePerson(Person p) {
    if (p.getEntity() == null) {
        return false;
    }

    p.getEntity().setProperty("name", p.getName());
    p.getEntity().setProperty("token", p.getToken());
    p.getEntity().setProperty("messages", p.getMessages());
    p.getEntity().setProperty("completedTests", p.getCompletedTests());

    EmbeddedEntity ee = new EmbeddedEntity();
    Map<String, String> testInformation = p.getTestInformation();

    for (String key : testInformation.keySet()) { // TODO: maybe there is a more efficient way of solving this
        ee.setProperty(key, testInformation.get(key));
    }

    p.getEntity().setProperty("testInformation", ee);
    DatastoreServiceFactory.getDatastoreService().put(p.getEntity());

    return true;
}