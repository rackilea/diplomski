public class MyParameterHider extends HttpServletRequestWrapper {
    public MyParameterHider(HttpServletRequest request) {
        super(request);
    }
    public String getParameter(String name) {
       if ("parameterToHide".equals(name))
           return null;
       return realRequest.getParameter(name);
    }
    // similar for getParameterNames and getParameterMap - don't include the hidden parm
    // all other methods are strictly pass-through and are automatically
    //   handled by HttpServletRequestWrapper
}