@RepositoryEventHandler 
public class OperationEventHandler {

  @Autowired
  private HttPServletRequest request;

  @HandleBeforeSave
  public void handleOperationSave(Operation operation) {

      User user = (User)request.getSession().getAttribute("userKey");
      operation.setUser(user); 
  }
}