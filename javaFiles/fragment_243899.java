String path = "/shopping";   
WebAppContext wac = new WebAppContext(WEBAPP_PATH, path); 
contexts.addHandler(wac); 
wac.addServlet(new ServletHolder(new WebappServlet()), "/anything/*");

public class WebappServlet extends HttpServlet 
{    
    private static final long serialVersionUID = 1L;    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException     {               
        request.getRequestDispatcher("/index.html").forward(request, response);  
    }  
}