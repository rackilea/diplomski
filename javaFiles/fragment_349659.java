messageContextMock = mock(MessageContext.class);

saajSoapMessageMock = mock(SaajSoapMessage.class);
soapEnvelopeMock = mock(SOAPEnvelope.class);

when(saajSoapMessageMock.getEnvelope()).thenReturn(soapEnvelopeMock);
when(messageContextMock.getRequest()).thenReturn(saajSoapMessageMock);