public class PersonTest {

    /** Syntactic sugaring for having a hasName matcher method */
    public static Matcher<Person> hasName(final String name) {
        return new BaseMatcher<Person>() {
            public boolean matches(Object o) {
               return  ((Person) o).getName().equals(name);
            }

            public void describeTo(Description description) {
                description.appendText("Person should have the name ")
                           .appendValue(name);
            }
        };
    }

    @Test
    public void testPeople() {
        List<Person> people = 
            Arrays.asList(new Person("Steve"), new Person("Peter"));

        assertThat(people, hasItem(hasName("Peter")));
    }
}