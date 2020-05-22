public class HelloWorldService1MessageReceiverInOut extends
    org.apache.axis2.receivers.AbstractInOutMessageReceiver {
  @Override
  public void invokeBusinessLogic(
      org.apache.axis2.context.MessageContext msgContext,
      org.apache.axis2.context.MessageContext newMsgContext)
      throws org.apache.axis2.AxisFault {

/* ... */

          www.helloworldws.DireBonjourResponse direBonjourResponse2 = null;
          try {
            www.helloworldws.DireBonjourRequest wrappedParam = (www.helloworldws.DireBonjourRequest) fromOM(
                msgContext.getEnvelope().getBody().getFirstElement(),
                www.helloworldws.DireBonjourRequest.class,
                getEnvelopeNamespaces(msgContext.getEnvelope()));
            direBonjourResponse2 = skel.direBonjour(wrappedParam);
          } catch (AxisFault e) {
            logger.info(e.getCause() + ", " + e.getMessage());
            DireBonjourResponse direBonjourResponse = new DireBonjourResponse();
            direBonjourResponse.setAge(0);
            direBonjourResponse.setSalutations("[AxisFault] " + e.getMessage()); // Use of the message setted in the RuntimeException
            direBonjourResponse2 = direBonjourResponse;
          }

          envelope = toEnvelope(getSOAPFactory(msgContext),
              direBonjourResponse2, false, new javax.xml.namespace.QName(
                  "http://www.example.fr/helloworldws/", "direBonjour"));

/* ... */

  }
}