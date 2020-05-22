public class MyServlet extends HttpServlet {

    protected String s;

    @Override 
    public void init(ServletConfig servletConfig) throws ServletException{
        super(servletConfig);
        this.s = servletConfig.getInitParameter("myParam");
    }

    ....

}