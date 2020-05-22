@Test
public void testEquals_Symmetric() {
    Person x = new Person("Foo Bar");  // equals and hashCode check name field value
    Person y = new Person("Foo Bar");
    Assert.assertTrue(x.equals(y) && y.equals(x));
    Assert.assertTrue(x.hashCode() == y.hashCode());
}