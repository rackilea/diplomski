@Test
public void testDriverFailure()
{
    ....
    try
    {
        try to init your dbConnector. 
    } Catch exceptions (
          They never thrown, because you already catched them in the method connectionInit().
          And here right now, you know, why its a bad idea 
          to catch exceptions and place them into logfiles (except in the very high level of your application)!
      )
    {
        Now Check, that the Java-VM ClassLoader (Not your code!!!) will throw an ClassNotFoundException. 
        Why you not trusting the jvm developers? ;)
    }
}