@EJB
QueueService queueService;

@TransactionAttribute(TransactionAttributeType.REQUIRED)
public void onMessage(Message message) {
  try{
    queueService.processMessageInNewTrasaction(message);
  }catch(Exception e){
    throw e;
  }
}