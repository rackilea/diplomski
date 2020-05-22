public class Page1 extends ActionSupport implements ServletRequestAware {
  public HttpServletRequest request;

  @Override
  public String execute() {
    String contextPath = request.getContextPath();
    System.out.println("Context Path " + contextPath);
    return SUCCESS;
  }

  @Override
  public void setServletRequest(HttpServletRequest request) {
    this.request = request;  
    }
}