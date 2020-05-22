private WebServiceOperations getMockWebServiceOperations(final String faultString)
{
  WebServiceOperations mockObj = Mockito.mock(WebServiceOperations.class);

  SoapFault soapFault = Mockito.mock(SoapFault.class);
  when(soapFault.getFaultStringOrReason()).thenReturn(faultString);

  SoapBody soapBody = Mockito.mock(SoapBody.class);
  when(soapBody.getFault()).thenReturn(soapFault);

  SoapMessage soapMsg = Mockito.mock(SoapMessage.class);
  when(soapMsg.getSoapBody()).thenReturn(soapBody);

  doThrow(new SoapFaultClientException(soapMsg)).when(mockObj).sendSourceAndReceiveToResult(anyString(), any(StreamSource.class), any(StreamResult.class));

  return mockObj;
}