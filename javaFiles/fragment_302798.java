public class LoginAction implements ServletResponseAware{

    HttpServletResponse response;

    //business logic
    public String execute() {
        Locale locale = getServletResponse().getLocale();
        return "SUCCESS";
    }

    public void setServletResponse(HttpServletResponse response) {
        this.response = response;
    }
    public HttpServletResponse getServletResponse() {
        return this.response;
    }   
}