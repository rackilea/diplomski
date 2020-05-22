public class LisResponseInterceptor extends EndpointInterceptorAdapter {

    @Override
    public boolean handleResponse(MessageContext messageContext, Object endpoint{
        return true;
    }

    @Override
    public boolean handleRequest(MessageContext messageContext, Object endpoint){
        return true;
    }

    @Override
    public boolean handleFault(MessageContext messageContext, Object endpoint){

        SoapMessage response = (SoapMessage) messageContext.getResponse();
        SoapHeader header = response.getSoapHeader();
        header.addHeaderElement(new QName("ims","imsx_syncRequestHeaderInfo"));

        return true;
    }
}