Person p = new Person(id);
p.setName((String) e.getProperty("name"));
p.setToken((String) e.getProperty("token"));
p.setMessages((List<String>) e.getProperty("messages"));
p.setCompletedTests((List<String>) e.getProperty("completedTests"));

Map<String, String> ti = new HashMap<>();
EmbeddedEntity ee = (EmbeddedEntity) e.getProperty("testInformation");
if (ee != null) {
    for (String key : ee.getProperties().keySet()) {
        ti.put(key, (String) ee.getProperty(key));
    }
    p.setTestInformation(ti);
}
p.setEntity(e);