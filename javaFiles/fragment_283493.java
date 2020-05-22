@Component
public class MyErrorHandler {

  /**
   * Actual error handler invoked as service
   */
  public void checkError(DelegateExecution execution) {

    execution.getVariables(); // Map<String, Object> of variables

    execution.setVariable("errorCode", 500); // update variable
  }
}