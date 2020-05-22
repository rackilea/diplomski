@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
@Stateless
public class ErrorQueueHandler{
   public void sendToErrorQueue(Message message){
   .
   .
   }
}