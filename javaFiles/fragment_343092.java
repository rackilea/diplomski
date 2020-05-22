public class SoapHeadersHandler implements SOAPHandler<SOAPMessageContext>
{

  @Override
  public boolean handleMessage(SOAPMessageContext soapMessageContext)
  {
    try
    {
      Object[] headers = soapMessageContext.getHeaders(...);
    }
    catch (SOAPException e)
    {
      // Handle exception
    }

    return true;
  }

}