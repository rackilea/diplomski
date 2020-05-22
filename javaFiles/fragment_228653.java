private WebServiceOperations getMockWebServiceOperations(final String resultXml)
{
  WebServiceOperations mockObj = Mockito.mock(WebServiceOperations.class);

  doAnswer(new Answer()
  {
    public Object answer(InvocationOnMock invocation)
    {
      try
      {
        Object[] args = invocation.getArguments();
        StreamResult result = (StreamResult)args[2];
        Writer output = result.getWriter();
        output.write(resultXml);
      }
      catch (IOException e)
      {
        e.printStackTrace();
      }

      return null;
    }
  }).when(mockObj).sendSourceAndReceiveToResult(anyString(), any(StreamSource.class), any(StreamResult.class));

  return mockObj;
}