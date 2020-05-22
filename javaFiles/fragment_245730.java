@Test
public void differenceTest()
{
    MutableSet<Person> differenceSet = Sets.differenceInto(
        HashingStrategySets.mutable.with(hashingStrategy), 
        set1, 
        set2);

    Assert.assertEquals(Sets.mutable.with(person1), differenceSet);
}