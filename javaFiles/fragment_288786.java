static void assertStreamEquals(Stream<?> s1, Stream<?> s2)
{
    Iterator<?> iter1 = s1.iterator(), iter2 = s2.iterator();
    while(iter1.hasNext() && iter2.hasNext())
        assertEquals(iter1.next(), iter2.next());
    assert !iter1.hasNext() && !iter2.hasNext();
}