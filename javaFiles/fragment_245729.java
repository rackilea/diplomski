@Test
public void removeIfTest()
{
    MutableSet<Person> personHashingStrategySet = HashingStrategySets.mutable.withAll(
        hashingStrategy, personSet2);

    // removeIf mutates the personSet1
    personSet1.removeIf(personHashingStrategySet::contains);
    Assert.assertEquals(Sets.mutable.with(person1, person3), personSet1);
}