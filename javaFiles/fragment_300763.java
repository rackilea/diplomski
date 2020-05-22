public class CustomerResource extends ServerResource
{
  @Get("xml")
  public Representation toXml() throws ResourceException, Exception
  {
      try
      {
          //get param from request
          getQuery().getValues("userId")
         //call DAO with parameter
      }
      catch(Exception e)
      {
          throw e;
      }
  }
}