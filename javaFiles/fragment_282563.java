public class MinimalServlets
{
    public static void main(String[] args) throws Exception
    {
        Server server = new Server();
        Connector connector = new SocketConnector();
        connector.setPort(8080);
        server.setConnectors(new Connector[]
        { connector });

        ServletHandler handler = new ServletHandler();
        server.setHandler(handler);

        handler.addServletWithMapping("org.eclipse.jetty.embedded.MinimalServlets$HelloServlet","/");

        server.start();
        server.join();
    }

    public static class HelloServlet extends HttpServlet
    {
        @Override
        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
        {
            response.setContentType("text/html");
            response.setStatus(HttpServletResponse.SC_OK);
            response.getWriter().println("<h1>Hello SimpleServlet</h1>");
        }
    }
}