class YourClass
{
Logger logger = Logger.getLogger(YourClass.class.getName());

...

public void someMethod() throws YourException
{
  try
  {
    // your code here
  } catch (NullPointerException e)
  {
    String message = "Unexpected NullPointerException in processing!";
    logger.log(Level.ERROR, message, e);

    throw new YourException(message, e);
  }
}

}