@Test
public void testDriverFailure()
{
    ....
    try
    {
        dbConnector.connectionInit();
    } catch (Exception e)
    {
        assertTrue(e instanceof ClassNotFoundException);
    }
}