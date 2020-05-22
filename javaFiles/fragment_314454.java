class Proxy extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws   ServletException, IOException {
        // Perform a new request to get contents from secured page
        HttpClient client = new HttpClient();
        Credentials credentials = new UsernamePasswordCredentials("user", "pass");
        client.getState().setCredentials(authScope, credentials);
        GetMethod method = new GetMethod("/secure_page.jsp");
        client.executeMethod(client.getHostConfiguration();, method);

        // write result to the outputstream
        resp.getWriter().write( method.getResponseBodyAsString() );
    }
}