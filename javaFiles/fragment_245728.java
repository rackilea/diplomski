@Test
public void reject()
{
    MutableSet<Person> personHashingStrategySet = HashingStrategySets.mutable.withAll(
        hashingStrategy, personSet2);

    // reject creates a new copy
    MutableSet<Person> rejectSet = personSet1.reject(personHashingStrategySet::contains);
    Assert.assertEquals(Sets.mutable.with(person1, person3), rejectSet);
}