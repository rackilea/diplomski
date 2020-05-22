public class SoapResponseInterceptor extends AbstractSoapInterceptor {

    public SoapResponseInterceptor() {
        super(Phase.PRE_LOGICAL);
    }

    @Override
    public void handleMessage(SoapMessage message) throws Fault {
        message.getExchange().setOneWay(false);
    }
}