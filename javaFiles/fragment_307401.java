@Override
public void handleRequest(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

    RequestDispatcher rd = this.servletContext.getNamedDispatcher(this.defaultServletName);
    if (rd == null) {
        throw new IllegalStateException("A RequestDispatcher could not be located for the default servlet '" +
                this.defaultServletName +"'");
    }
    rd.forward(request, response);
}