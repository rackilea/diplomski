import javax.jms.Message;
@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
@Stateless
public class QueueService {

  @EJB
  ErrorQueueHandler errorQueueHandler;

  public void processMessageInNewTransaction(Message message){
    try {
    .
    .
    } catch(Exception e) {
      if(isUserExceptionWrappedInException(e)
        errorQueueHandler.sendToErrorQueue(message);
    }
  }

  private boolean isUserExceptionWrappedInException(Throwable t) {
    if (t == null)
      return false;
    else if (t instanceof UserException)
      return true;
    else
      return isUserExceptionWrappedInException(t.getCause());
  }

}