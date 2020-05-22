public class C {

    private HttpServletRequest request;
    //initialize request in a constructor

    public String getAttr() {
        return "foo <a href = \""+request.getContextPath()+"/index.html\">bar</a> baz";
    }
}