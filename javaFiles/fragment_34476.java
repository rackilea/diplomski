@Autowired
  private Jaxb2Marshaller jaxb2Marshaller;

  @Override
  public boolean handleRequest(MessageContext messageContext, Object endpoint) throws Exception {

    boolean proceed = true;

    SaajSoapMessage saajSoapMessage = (SaajSoapMessage) messageContext.getRequest();


    SoapBody requestBody = saajSoapMessage.getSoapBody();
    Object obj = jaxb2Marshaller.unmarshal(requestBody.getPayloadSource());


    if (obj instanceof ConfirmOrderRequest ) {
      ConfirmOrderRequest cor = (ConfirmOrderRequest ) obj;

      String orderId = cor.getOrderId();

      ...........
      .......
    }
  .....
 }