public class ExampleAppServlet extends HttpServlet{
    public void doPost(HttpServletRequest req, HttpServletResponse resp) {

        // get some data from POST
        InputStream input = req.getInputStream();

        // do something with input

        // send back some reply
        resp.getWriter().write("Hello Example App").close();
    } 
}