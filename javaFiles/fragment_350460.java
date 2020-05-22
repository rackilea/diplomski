public class YourServlet {

  protected String url = null;

  public void init(ServletConfig servletConfig) throws ServletException {
    this.url = servletConfig.getInitParameter("url");
  }

  public void service(ServletRequest request, ServletResponse response)
        throws ServletException, IOException {

    RequestDispatcher view = request.getRequestDispatcher(url);  

  }
}