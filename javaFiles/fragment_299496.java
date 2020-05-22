public class InboundSMSServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req,
                         HttpServletResponse resp)
            throws ServletException,
                   java.io.IOException {
        System.out.println("Received: " + req.getMethod());
        for (String param : Collections.list(req.getParameterNames())) {
            String value = req.getParameter(param);
            System.out.println(param + ": " + value);
        }
    }
}