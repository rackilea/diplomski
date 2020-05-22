@Bean("messageFactory")
public SoapMessageFactory messageFactory() {
   var messageFactory = new DualProtocolSaajSoapMessageFactory();

   return messageFactory;
}