@NodeEntity
public class Person {
    @GraphId
    private Long graphId;

    private DynamicProperties personalProperties;
    public void setProperty(String key, Object value) {
        personalProperties.setProperty(key, value);
    }

    public Object getProperty(String key) {
        return personalProperties.getProperty(key);
    }
}
@Test
    public void testCreateOutsideTransaction() {
        Person p = new Person("James", 35);
        p.setProperty("s", "String");
        p.setProperty("x", 100);
        p.setProperty("pi", 3.1415);
        persist(p);
        assertEquals(3, IteratorUtil.count(p.getPersonalProperties().getPropertyKeys()));
        assertProperties(nodeFor(p));
        p.setProperty("s", "String two");
        persist(p);
        assertEquals("String two", nodeFor(p).getProperty("personalProperties-s"));
    }