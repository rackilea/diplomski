@Test
public void testPerson() {
    InterplanetaryTravelling<Person> traveller = new Person();
    assertEquals("", traveller.whereWasI());

    traveller = new ToEarth<>(traveller);
    assertEquals("Earth", traveller.getCurrentPlanet());
    assertEquals("Earth", traveller.whereWasI());

    traveller = new ToMars<>(traveller);
    assertEquals("Mars", traveller.getCurrentPlanet());
    assertEquals("Earth, Mars", traveller.whereWasI());
}

@Test
public void testDog() {
    InterplanetaryTravelling<Dog> traveller = new Shepherd();
    assertEquals("", traveller.whereWasI());
    // ... same as for the person
}

@Test
public void testTypeSafety() {
    InterplanetaryTravelling<Person> traveller = new Shepherd(); // Compiler Error
}