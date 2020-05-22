public class MyMDB implements MessageListener {

  @Resource
  private MessageDrivenContext context;

  public void onMessage() {
     try {
        //some other processing
        someService.create(entity);
     }
     catch(Exception e) {
        //mark the message as undelivered
        context.setRollbackOnly();
     }
  }
}