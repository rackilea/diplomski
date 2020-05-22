public class InterceptorMensajeSOAPIn extends AbstractSoapInterceptor {

      private static Logger log =
Logger.getLogger(InterceptorMensajeSOAPIn.class);



      private SAAJInInterceptor saajIn = new SAAJInInterceptor();

      public InterceptorMensajeSOAPIn(){

            super(Phase.PRE_PROTOCOL);

            getAfter().add(SAAJInInterceptor.class.getName());

      } 


      public void handleMessage(SoapMessage message) throws Fault {

        SOAPMessage soapMessage = getSOAPMessage(message);

        try {

                  soapMessage.writeTo(System.out);

            } catch (Exception e) {

                  e.printStackTrace();

            }
      }


      private SOAPMessage getSOAPMessage(SoapMessage smsg){

            SOAPMessage soapMessage = smsg.getContent(SOAPMessage.class);

        if (soapMessage == null) {

            saajIn.handleMessage(smsg);

            soapMessage = smsg.getContent(SOAPMessage.class);

        }   

        return soapMessage;

      }
}