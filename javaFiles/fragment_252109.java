public class SimpleServletContext
{
    public static void main(String[] args) throws Exception
    {
        Server server = new Server(8080);

        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        context.setContextPath("/");
        server.setHandler(context);

        context.addServlet(new ServletHolder(new PostServlet()),"/*");

        server.start();
        server.join();
    }
}

public class PostServlet extends HttpServlet
{
    public PostServlet()
    { 
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        // do something with the posted data
    }
}