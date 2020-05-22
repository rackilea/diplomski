public class RestletHttpServlet extends HttpServlet {

    private ServletAdapter adapter;
    private final Restlet restlet;

    public RestletHttpServlet(Restlet restlet) {
        this.restlet = restlet;
    }

    @Override
    public void init() throws ServletException {
        super.init();
        this.adapter = new ServletAdapter(getServletContext());
        this.restlet.setContext(this.adapter.getContext());
        this.adapter.setNext(this.restlet);
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.adapter.service(req, resp);
    }
}