@Test
public void testConnectionFailure()
{
    ...
    try
    {
        dbConnector.connectionInit();
        fail("an exception should be thrown...")
    } catch (Exception e)
    {
        assertTrue(e instanceof SQLException);
    }
    ...
}