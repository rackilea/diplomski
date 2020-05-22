public class SchemeActionBeanContext extends ActionBeanContext {
    public void setThings(List<Things> things) {    
        getRequest().getSession().setAttribute("stuff", things);
    }

    public List<Things> getThings() {
        return (List<Things>)getRequest().getSession().getAttribute("stuff");
    }