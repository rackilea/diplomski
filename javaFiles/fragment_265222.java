public class MyPostServlet extends HttpServlet
{
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        // Get POST parameters
        String val = req.getParameter("foo");
        // Do something with 'foo'
        String result = backend.setValue("foo", val);
        // Write a response
        resp.setContentType("text/plain");
        resp.setCharacterEncoding("UTF-8");
        resp.getWriter().printf("foo = %s (result: %s)%n",val,result);
    }
}