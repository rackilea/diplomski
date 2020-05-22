public class MyCxfInterceptor extends CxfMessageSoapHeaderOutInterceptor {
   @Override
   public void handleMessage( org.apache.cxf.binding.soap.SoapMessage message) {

      org.apache.cxf.binding.soap.SoapHeader myCustomHeader = new org.apache.cxf.binding.soap.SoapHeader(new QName(
                {custom name space}, {custom local name}), {Custom content object}));

        myCustomHeader.setMustUnderstand(true);

        message.getHeaders().add(myCustomHeader);

   }