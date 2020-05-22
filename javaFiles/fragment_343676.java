public class MyAction extends ActionSupport implements ServletRequestAware {
   private HttpServletRequest request;

   public void setRequest(HttpServletRequest request) {
      this.request = request;
   }

   public HttpServletRequest getRequest() {
      return this.request;
   }

   public String execute() throws Exception{
      boolean ajax = "XMLHttpRequest".equals(
                      getRequest().getHeader("X-Requested-With"));
      if (ajax)
         log.debug("This is an AJAX request");
      else 
         log.debug("This is an ordinary request");

      return SUCCESS;
   }  
}