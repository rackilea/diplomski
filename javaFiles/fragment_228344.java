public class SampleServlet extends DesignerFacesServlet implements Serializable {
    private static final long serialVersionUID = 1L;

    @SuppressWarnings("unchecked")
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        // Set up handy environment variables
        HttpServletRequest req = (HttpServletRequest)servletRequest;
        HttpServletResponse res = (HttpServletResponse)servletResponse;
        ServletOutputStream out = res.getOutputStream();
        FacesContext facesContext = this.getFacesContext(req, res);

        try {
            res.setContentType("text/plain");

            // write some amazing code!

            out.println("done");

        } catch(Exception e) {
            e.printStackTrace(new PrintStream(out));
        } finally {
            out.close();

            // It shouldn't be null if things are going well, but a check never hurt
            if(facesContext != null) {
                facesContext.responseComplete();
                facesContext.release();
            }
        }
    }
}