@Component
@RequestScope
class MyBean {
    final HttpServletRequest request;

    public MyBean(HttpServletRequest request) {
        this.request = request;
    }        

    public String getParameter(String name){
        // do something 
        return request.getParameter(name);
    }
}