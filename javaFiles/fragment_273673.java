class MyTestCase extends TestCase
{
    static AtomicInteger seed = new AtomicInteger();

    public void testUpdateEntry()
    {
       int seedValue = seed.getAndIncrement();

       // generate entries from seed
       // write entries to db
    }

}