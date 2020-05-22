public class LoggingInterceptor extends AbstractPhaseInterceptor<Message>
{
   //...//
    public void handleMessage(Message message) throws Fault
    {
       Message inMessage = message.getExchange().getInMessage();
       MessageInfo mi = (MessageInfo) inMessage.get("org.apache.cxf.service.model.MessageInfo");
       String methodName = mi.getOperation().getInputName();
       //...
    }
}