@Test
public void testCanConstructAPersonWithAName() {
    String firstName = "Larry";
    Person person = new Person(firstName);
    // the person's name attribute is expected to be firstName
    assertEquals(firstName , person.getName());
}